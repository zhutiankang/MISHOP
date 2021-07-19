/*
 * CONFIDENTIAL - FORD MOTOR COMPANY
 *
 * This is an unpublished work, which is a trade secret, created in
 * 2021.  Ford Motor Company owns all rights to this work and intends
 * to maintain it in confidence to preserve its trade secret status.
 * Ford Motor Company reserves the right to protect this work as an
 * unpublished copyrighted work in the event of an inadvertent or
 * deliberate unauthorized publication.  Ford Motor Company also
 * reserves its rights under the copyright laws to protect this work
 * as a published work.  Those having access to this work may not copy
 * it, use it, or disclose the information contained in it without
 * the written authorization of Ford Motor Company.
 *
 */

package com.northlight.latte.net.rx;

import com.ford.sync.tspservice.model.entity.ReqBodyConsent;
import com.ford.sync.tspservice.model.entity.ReqBodyLatest;
import com.ford.sync.tspservice.model.entity.RespBody;
import com.ford.sync.tspservice.model.entity.RespTermsResult;
import com.northlight.latte.net.NetResponse;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
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
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface CloudApi {

    @GET("/api/ivisl/terms/{apiVersion}/")
    Observable<RespBody<String>> getTerms(
            @Path("apiVersion") String apiVersion,
            @Header("Application-Id") String applicationId,
            @Header("Platform-Id") String platformId,
            @Header("Device-Id") String deviceId,
            @Header("Token") String token,
            @Query("hwconfig") String hwConfig,
            @Query("feature") String feature,
            @Query("doctype") String docType,
            @Query("llid") String llId,
            @Query("nonce") String nonce,
            @Query("timestamp") String timeStamp,
            @Query("sign") String sign
    );

    @POST("/api/ivisl/terms/latest/{apiVersion}/")
    Observable<RespBody<RespTermsResult>> getTermsLatest(
            @Path("apiVersion") String apiVersion,
            @Header("Application-Id") String applicationId,
            @Header("Platform-Id") String platformId,
            @Header("Device-Id") String deviceId,
            @Header("Token") String token,
            @Body ReqBodyLatest body
    );

    @POST("/api/ivisl/terms/consent/{apiVersion}/")
    Observable<RespBody<String>> consentTerms(
            @Path("apiVersion") String apiVersion,
            @Header("Application-Id") String applicationId,
            @Header("Platform-Id") String platformId,
            @Header("Device-Id") String deviceId,
            @Header("Token") String token,
            @Body ReqBodyConsent body
    );

    public interface a {
        @POST
        @FormUrlEncoded
        @NotNull
        Observable a(@Url @NotNull String var1, @FieldMap @NotNull Map var2, @Header("requestId") @NotNull String var3, @HeaderMap @NotNull Map var4);

        @POST
        @NotNull
        Observable a(@Url @NotNull String var1, @Body @NotNull Object var2, @Header("requestId") @NotNull String var3, @HeaderMap @NotNull Map var4);

        @DELETE
        @NotNull
        Observable c(@Url @NotNull String var1, @QueryMap @NotNull Map var2, @Header("requestId") @NotNull String var3, @HeaderMap @NotNull Map var4);

        @DELETE
        @NotNull
        Observable a(@Url @NotNull String var1, @Header("requestId") @NotNull String var2, @HeaderMap @NotNull Map var3);

        @PUT
        @FormUrlEncoded
        @NotNull
        Observable b(@Url @NotNull String var1, @FieldMap @NotNull Map var2, @Header("requestId") @NotNull String var3, @HeaderMap @NotNull Map var4);

        @PUT
        @NotNull
        Observable b(@Url @NotNull String var1, @Body @NotNull Object var2, @Header("requestId") @NotNull String var3, @HeaderMap @NotNull Map var4);

        @GET
        @NotNull
        Observable d(@Url @NotNull String var1, @QueryMap @NotNull Map var2, @Header("requestId") @NotNull String var3, @HeaderMap @NotNull Map var4);

        @GET
        @NotNull
        Observable b(@Url @NotNull String var1, @Header("requestId") @NotNull String var2, @HeaderMap @NotNull Map var3);

        @Multipart
        @POST
        @NotNull
        Observable a(@Url @NotNull String var1, @Header("requestId") @NotNull String var2, @HeaderMap @NotNull Map var3, @PartMap @NotNull Map var4, @Part @NotNull okhttp3.MultipartBody.Part var5);

        @Streaming
        @GET
        @NotNull
        Flowable c(@Header("Range") @NotNull String var1, @Url @NotNull String var2);

        @HEAD
        @NotNull
        Observable a(@Url @NotNull String var1);

        @GET
        @NotNull
        Observable b(@Url @NotNull String var1);

        @HEAD
        @NotNull
        Observable b(@Header("Range") @NotNull String var1, @Url @NotNull String var2);

        @HEAD
        @NotNull
        Observable a(@Header("If-Modified-Since") @NotNull String var1, @Url @NotNull String var2);


//        subscribe(new Observer<DownloadStatus>() {
//            public void onSubscribe(@NotNull Disposable var1) {
//                Intrinsics.checkNotNullParameter(var1, "disposable");
//                com.t3.network.helper.f.d.a(var7.a, var1, (NetResponse)null);
//                LogExtKt.log$default("network", var7.a + "->" + var7.b.getDownloadUrl(), (LogType)null, 4, (Object)null);
//                var2.onStart(var7.a);
//            }
//
//            public void onNext(Object var1) {
//                DownloadStatus var2x;
//                Intrinsics.checkNotNullParameter(var2x = (DownloadStatus)var1, "downloadStatus");
//                LogExtKt.log$default("network", "downloading:" + var2x.getDownloadSize() * (long)100 / var2x.getTotalSize() + "%}", (LogType)null, 4, (Object)null);
//                var2.onSuccess(var7.a, 3, var2x, "downloading");
//            }
//
//            public void onError(@NotNull Throwable var1) {
//                Intrinsics.checkNotNullParameter(var1, "throwable");
//                NetError var5;
//                NetError var10000 = var5 = OkHttpExtKt.handleException(var1);
//                String var2x = "network";
//                String var3;
//                if ((var3 = var10000.getMessage()) == null) {
//                    var3 = "download failure:" + var7.b.getDownloadUrl();
//                }
//
//                var10000 = var5;
//                NetError var10001 = var5;
//                LogExtKt.log$default(var2x, var3, (LogType)null, 4, (Object)null);
//                NetResponse var6 = var2;
//                var2x = var7.a;
//                int var7x = var10001.getCode();
//                String var4;
//                if ((var4 = var10000.getMessage()) == null) {
//                    var4 = "";
//                }
//
//                var6.onError(var2x, var7x, var4);
//                this.onComplete();
//            }
//
//            public void onComplete() {
//                LogExtKt.log$default("network", "download completed:" + var7.b.getDownloadUrl(), (LogType)null, 4, (Object)null);
//                var2.onComplete(var7.a);
//                b.this.a(var7.a);
//            }
//        });
    }
}