package com.gigigo.ggglib.network.mappers;

import com.gigigo.ggglib.core.business.model.BusinessContentType;
import com.gigigo.ggglib.core.business.model.BusinessError;
import com.gigigo.ggglib.mappers.ExternalClassToModelMapper;
import com.gigigo.ggglib.network.responses.ApiErrorDataMock;
import com.gigigo.ggglib.network.responses.ApiGenericExceptionResponse;

public class BaseApiResponseMapper<Model, Data>
    extends ApiGenericResponseMapper<Model, Data, ApiErrorDataMock> {

  public BaseApiResponseMapper(ExternalClassToModelMapper<Model, Data> mapper) {
    super(mapper);
  }

  @Override protected BusinessError createBusinessError(ApiErrorDataMock apiErrorDataMock,
      Data result) {
    int code = apiErrorDataMock.getCode();
    String message = apiErrorDataMock.getMessage();
    BusinessError businessError =
        new BusinessError(code, message, BusinessContentType.BUSINESS_ERROR_CONTENT);
    return businessError;
  }

  @Override protected BusinessError onException(ApiGenericExceptionResponse exceptionResponse) {
    int code = BusinessError.EXCEPTION_BUSINESS_ERROR_CODE;
    String message = exceptionResponse.getError().getMessage();
    BusinessError businessError =
        new BusinessError(code, message, BusinessContentType.EXCEPTION_CONTENT);
    return businessError;
  }
}
