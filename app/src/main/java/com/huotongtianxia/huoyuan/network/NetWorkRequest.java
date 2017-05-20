package com.huotongtianxia.huoyuan.network;

import com.huotongtianxia.huoyuan.bean.DoorPhotoBean;
import com.huotongtianxia.huoyuan.bean.HuoYuanPhoto;
import com.huotongtianxia.huoyuan.bean.HuoyuanPhotoBean;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述:    [网络操作的具体实现类]
 * 创建人:    Gjl
 * 创建时间:  2016/8/17 10:16
 * 修改人:
 * 修改时间:  2016/8/17 10:16
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class NetWorkRequest {



    //上传图片
    public static Observable<HuoYuanPhoto> uploadImgs(String factory_id,List<String> paths,String des){

        Map<String, RequestBody> bodyMap = new HashMap<String, RequestBody>();
       ;
        if("door".equals(des)){
            File file = new File(paths.get(0));
            bodyMap.put("door\";filename=\"" + file.getName(),
                    RequestBody.create(MediaType.parse("image/png"), file));

        }else {
            for (int i = 0; i < paths.size(); i++) {
                File file = new File(paths.get(i));
                if (0 == i) {
                    bodyMap.put("photo\";filename=\"" + file.getName(),
                            RequestBody.create(MediaType.parse("image/png"), file));
                } else {

                    bodyMap.put("photo" + (i + 1) + "\";filename=\"" + file.getName(),
                            RequestBody.create(MediaType.parse("image/png"), file));
                }
//            RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
//            MultipartBody.Part body =
//                    MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
            }
        }
        return NetWork.getApi().iuploadImgs(factory_id,des,bodyMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    //获取门头图片
    public static Observable<DoorPhotoBean> getDoorImgs(String factory_id, String info){

        return NetWork.getApi().igetDoorImgs(factory_id,info)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //获取货源图片
    public static Observable<HuoyuanPhotoBean> getHuoyuanImgs(String factory_id, String info){

        return NetWork.getApi().igetHuoyuanImgs(factory_id,info)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



//    //上传图片
//    public static Observable<UploadImg> uploadImg(String path){
//
//        File file=new File(path);
//        RequestBody requestBody= RequestBody.create(MediaType.parse("image/jpg"),file);
//        MultipartBody.Part body=
//                MultipartBody.Part.createFormData("picture",file.getName(),requestBody);
//        return NetWork.getApi().iuploadImg(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//    }
//
//    //上传附件
//    public static Observable<UploadFile> uploadFile(String path){
//
//        File file=new File(path);
//        RequestBody requestBody= RequestBody.create(MediaType.parse("application/otcet-stream"),file);
//        MultipartBody.Part body=
//                MultipartBody.Part.createFormData("aFile",file.getName(),requestBody);
//        return NetWork.getApi().iuploadFile(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//    }


}
