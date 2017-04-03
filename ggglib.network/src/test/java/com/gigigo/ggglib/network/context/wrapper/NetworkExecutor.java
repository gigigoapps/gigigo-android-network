package com.gigigo.ggglib.network.context.wrapper;

import com.gigigo.ggglib.network.responses.ApiGenericResponse;

/**
 * Created by rui.alonso on 28/3/17.
 */

public interface NetworkExecutor<Request> {
  <ApiResponse extends ApiGenericResponse> ApiGenericResponse executeNetworkServiceConnection(
      Class<ApiResponse> responseType, Request requestType);
}