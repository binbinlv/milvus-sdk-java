package io.milvus.v2.service.database;

import io.milvus.grpc.ListDatabasesRequest;
import io.milvus.grpc.ListDatabasesResponse;
import io.milvus.grpc.MilvusServiceGrpc;
import io.milvus.v2.service.BaseService;
import io.milvus.v2.service.database.response.ListDatabaseResp;

import java.util.List;

public class DataBaseService extends BaseService {
    public ListDatabaseResp listDatabase(MilvusServiceGrpc.MilvusServiceBlockingStub blockingStub) {
        String title = "List Database";
        ListDatabasesRequest listDatabasesRequest = ListDatabasesRequest.newBuilder().build();
        ListDatabasesResponse listDatabasesResponse = blockingStub.listDatabases(listDatabasesRequest);
        rpcUtils.handleResponse(title, listDatabasesResponse.getStatus());
        return ListDatabaseResp.builder()
                .dbNames(listDatabasesResponse.getDbNamesList())
                .build();
    }
}
