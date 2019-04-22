package com.bugsir.mvp.sample.retrofit;

import com.bugsir.mvp.sample.bean.TestBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @author: BUG SIR
 * @description:
 */
public interface NetApiService {
    @POST()
    @FormUrlEncoded
    Call<ResponseBody> post(@Url String url, @FieldMap Map<String, String> maps);

    @GET()
    Call<ResponseBody> get(@Url String url, @QueryMap Map<String, String> maps);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("")
    Call<TestBean> testPost(@Body Map<String, Object> map);

}
