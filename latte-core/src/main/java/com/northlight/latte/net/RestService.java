package com.northlight.latte.net;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/27 09:13
 */

public interface RestService {


//      GET（SELECT）：从服务器取出资源（一项或多项）。
//      POST（CREATE）：在服务器新建一个资源。
//      PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
//      PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
//      DELETE（DELETE）：从服务器删除资源。
//
//      HEAD：获取资源的元数据。
//      OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。

//      GET /zoos：列出所有动物园
//      POST /zoos：新建一个动物园
//      GET /zoos/ID：获取某个指定动物园的信息
//      PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
//      PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
//      DELETE /zoos/ID：删除某个动物园

//            200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
//            201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
//            202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
//            204 NO CONTENT - [DELETE]：用户删除数据成功。
//            400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
//            401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
//            403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
//            404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
//            406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
//            410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
//            422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
//            500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。


    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String,Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String,Object> params, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String,Object> params);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String,Object> params, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);

    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body);

    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String,Object> params);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String,Object> params, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);

    @DELETE
    Call<String> delete(@Url String url, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);

    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String,Object> params);

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file, @PartMap @NotNull Map var4, @Header("requestId") String requestId, @HeaderMap Map<String,Object> headers);



    @HEAD
    @NotNull
    Observable head(@Url @NotNull String var1);

    @GET
    @NotNull
    Observable get(@Url @NotNull String var1);

    @HEAD
    @NotNull
    Observable headRange(@Header("Range") @NotNull String var1, @Url @NotNull String var2);

    @HEAD
    @NotNull
    Observable headModify(@Header("If-Modified-Since") @NotNull String var1, @Url @NotNull String var2);
}
