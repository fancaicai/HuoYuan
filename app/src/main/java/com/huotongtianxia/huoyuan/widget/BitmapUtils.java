package com.huotongtianxia.huoyuan.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;

import rx.Observable;

public class BitmapUtils {

    private BitmapUtils() {
    }

    /**
     * uri转Bitmap
     *
     * @param uri
     * @param context
     * @return
     */
    public static Bitmap decodeUriAsBitmap(Uri uri, Activity context) {
        Bitmap bitmap = null;
        try {
            // 先通过getContentResolver方法获得一个ContentResolver实例，
            // 调用openInputStream(Uri)方法获得uri关联的数据流stream
            // 把上一步获得的数据流解析成为bitmap
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }

    /**
     * 获得图片的旋转角度
     *
     * @param fileName image file path
     * @return degree
     */
    public static int getBitmapDegree(String fileName) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(fileName);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                case ExifInterface.ORIENTATION_TRANSPOSE:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                case ExifInterface.ORIENTATION_TRANSVERSE:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    public static File rotateImageFileIfNeeded(@NonNull File file) throws IOException {
        int degree = getBitmapDegree(file.getAbsolutePath());
        if (degree != 0) {
            Bitmap srcBitmap = decodeFixedWidthBitmap(file.getAbsolutePath(), 1080);

//            Bitmap srcBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (srcBitmap == null) {
                throw new IOException("Failed to decode file.");
            }
            Bitmap correctBitmap = rotateBitmapByDegree(srcBitmap, degree);
            File tempFile = File.createTempFile("CSL", null, null);
            bitmapToFile(correctBitmap, tempFile);
            return tempFile;
        } else {
            return file;
        }
    }

    public static void bitmapToFile(@NonNull Bitmap bitmap, @NonNull File outFile) throws FileNotFoundException {
        FileOutputStream fileOS = new FileOutputStream(outFile);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOS);
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (newBitmap != bitmap) {
            bitmap.recycle();
            bitmap = newBitmap;
        }
        return bitmap;
    }

    public static int[] getBitmapSize(String fileName) {
        return getBitmapSize(fileName, true);
    }

    /**
     * @param fileName image file
     * @param retry    some device should decode twice
     * @return bitmap size
     */
    public static int[] getBitmapSize(String fileName, boolean retry) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(fileName, options);
        if ((options.outWidth == -1 || options.outHeight == -1) && retry) {
            return getBitmapSize(fileName, false);
        }
        return new int[]{options.outWidth, options.outHeight};
    }

    /**
     * 得到bitmap的大小
     */
    public static int getBitmapSizeBuild(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {    //API 19
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {//API 12
            return bitmap.getByteCount();
        }
        // 在低版本中用一行的字节x高度
        return bitmap.getRowBytes() * bitmap.getHeight();                //earlier version
    }

    public static byte[] toByteArray(Bitmap bitmap) {
        if (bitmap != null) {
            ByteBuffer buffer = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(buffer);
            return buffer.array();
        }
        return new byte[]{};
    }

    public static void recycleImageViewBitmap(ImageView imageView) {
        if (imageView != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
            recycleBitmapDrawable(bitmapDrawable);
        }
    }

    private static void recycleBitmapDrawable(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            recycleBitmap(bitmap);
        }
        bitmapDrawable = null;
    }

    private static void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap = null;
        }
    }

//    public static Observable<Bitmap> decodeFixedWidthBitmapAsync(String pathName, int reqWidth) {
//        return Observable.defer(() -> Observable.just(decodeFixedWidthBitmap(pathName, reqWidth)));
//    }

    public static Bitmap decodeFixedWidthBitmap(String pathName, int reqWidth) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, options);
        if (options.outWidth > reqWidth) {
            options.inSampleSize = Math.round((float) options.outWidth / (float) reqWidth);
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(pathName, options);
    }

    /**
     * 根据计算的inSampleSize，得到压缩后图片
     *
     * @param pathName
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromResource(String pathName,
                                                         int reqWidth, int reqHeight) {
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, options);
        // 调用上面定义的方法计算inSampleSize值
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);


        //使用16位RGB位图压缩，有效减少内存且不失真
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        // 使用获取到的inSampleSize值再次解析图片

        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName, options);

        return bitmap;
    }


    /**
     * 根据计算的inSampleSize，得到压缩后图片
     *
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromResourceID(Resources resources, int id,
                                                           int reqWidth, int reqHeight) {
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, id);
        // 调用上面定义的方法计算inSampleSize值
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);
        //使用16位RGB位图压缩，有效减少内存且不失真
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        // 使用获取到的inSampleSize值再次解析图片

        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, id, options);
        return bitmap;
    }

    /**
     * 根据计算的inSampleSize，得到压缩后图片
     *
     * @param data
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromResource(byte[] data,
                                                         int reqWidth, int reqHeight) throws IOException {
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(data, 0, data.length, options);
        // 调用上面定义的方法计算inSampleSize值
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);


        //使用8位RGB位图压缩，有效减少内存且不失真
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        // 使用获取到的inSampleSize值再次解析图片

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(data, 0, data.length, options);
    }

    /**
     * 计算inSampleSize，用于压缩图片
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // 源图片的宽度
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;

        if (width > reqWidth && height > reqHeight) {
            // 计算出实际宽度和目标宽度的比率
            int widthRatio = Math.round((float) width / (float) reqWidth);
            int heightRatio = Math.round((float) height / (float) reqHeight);
            inSampleSize = Math.max(widthRatio, heightRatio);
        }
        return inSampleSize;
    }


    /**
     * 根据View获得适当的压缩的宽和高
     *
     * @param view
     * @return
     */
    public static int[] getViewWidth(View view) {
        final DisplayMetrics displayMetrics = view.getContext()
                .getResources().getDisplayMetrics();
        final ViewGroup.LayoutParams params = view.getLayoutParams();

        int width = params.width == ViewGroup.LayoutParams.WRAP_CONTENT ? 0 : view
                .getWidth(); // Get actual image width
        if (width <= 0)
            width = params.width; // Get layout width parameter
        if (width <= 0)
            width = getImageViewFieldValue(view, "mMaxWidth"); // Check
        // maxWidth
        // parameter
        if (width <= 0)
            width = displayMetrics.widthPixels;
        int height = params.height == ViewGroup.LayoutParams.WRAP_CONTENT ? 0 : view
                .getHeight(); // Get actual image height
        if (height <= 0)
            height = params.height; // Get layout height parameter
        if (height <= 0)
            height = getImageViewFieldValue(view, "mMaxHeight"); // Check
        // maxHeight
        // parameter
        if (height <= 0)
            height = displayMetrics.heightPixels;
        return new int[]{width, height};

    }


    /**
     * 反射获得ImageView设置的最大宽度和高度
     *
     * @param object
     * @param fieldName
     * @return
     */
    public static int getImageViewFieldValue(Object object, String fieldName) {
        int value = 0;
        try {
            Field field = ImageView.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            int fieldValue = (Integer) field.get(object);
            if (fieldValue > 0 && fieldValue < Integer.MAX_VALUE) {
                value = fieldValue;

                Log.e("TAG", value + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 转换文件大小
     *
     * @param fileS
     * @return
     */
    public static String formetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "b";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "kb";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "m";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "gb";
        }
        return fileSizeString;
    }
}