package com.ing.ipa.person;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: person/person.proto")
public final class PersonServiceGrpc {

  private PersonServiceGrpc() {}

  public static final String SERVICE_NAME = "person.PersonService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetPersonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ing.ipa.person.PersonGetRequest,
      com.ing.ipa.person.PersonGetResponse> METHOD_GET_PERSON = getGetPersonMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ing.ipa.person.PersonGetRequest,
      com.ing.ipa.person.PersonGetResponse> getGetPersonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ing.ipa.person.PersonGetRequest,
      com.ing.ipa.person.PersonGetResponse> getGetPersonMethod() {
    return getGetPersonMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ing.ipa.person.PersonGetRequest,
      com.ing.ipa.person.PersonGetResponse> getGetPersonMethodHelper() {
    io.grpc.MethodDescriptor<com.ing.ipa.person.PersonGetRequest, com.ing.ipa.person.PersonGetResponse> getGetPersonMethod;
    if ((getGetPersonMethod = PersonServiceGrpc.getGetPersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getGetPersonMethod = PersonServiceGrpc.getGetPersonMethod) == null) {
          PersonServiceGrpc.getGetPersonMethod = getGetPersonMethod = 
              io.grpc.MethodDescriptor.<com.ing.ipa.person.PersonGetRequest, com.ing.ipa.person.PersonGetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "person.PersonService", "GetPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ing.ipa.person.PersonGetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ing.ipa.person.PersonGetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("GetPerson"))
                  .build();
          }
        }
     }
     return getGetPersonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetPersonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ing.ipa.person.PersonSetRequest,
      com.ing.ipa.person.PersonSetResponse> METHOD_SET_PERSON = getSetPersonMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ing.ipa.person.PersonSetRequest,
      com.ing.ipa.person.PersonSetResponse> getSetPersonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ing.ipa.person.PersonSetRequest,
      com.ing.ipa.person.PersonSetResponse> getSetPersonMethod() {
    return getSetPersonMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ing.ipa.person.PersonSetRequest,
      com.ing.ipa.person.PersonSetResponse> getSetPersonMethodHelper() {
    io.grpc.MethodDescriptor<com.ing.ipa.person.PersonSetRequest, com.ing.ipa.person.PersonSetResponse> getSetPersonMethod;
    if ((getSetPersonMethod = PersonServiceGrpc.getSetPersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getSetPersonMethod = PersonServiceGrpc.getSetPersonMethod) == null) {
          PersonServiceGrpc.getSetPersonMethod = getSetPersonMethod = 
              io.grpc.MethodDescriptor.<com.ing.ipa.person.PersonSetRequest, com.ing.ipa.person.PersonSetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "person.PersonService", "SetPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ing.ipa.person.PersonSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ing.ipa.person.PersonSetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("SetPerson"))
                  .build();
          }
        }
     }
     return getSetPersonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeletePersonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ing.ipa.person.PersonDeleteRequest,
      com.ing.ipa.person.PersonDeleteResponse> METHOD_DELETE_PERSON = getDeletePersonMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ing.ipa.person.PersonDeleteRequest,
      com.ing.ipa.person.PersonDeleteResponse> getDeletePersonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ing.ipa.person.PersonDeleteRequest,
      com.ing.ipa.person.PersonDeleteResponse> getDeletePersonMethod() {
    return getDeletePersonMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ing.ipa.person.PersonDeleteRequest,
      com.ing.ipa.person.PersonDeleteResponse> getDeletePersonMethodHelper() {
    io.grpc.MethodDescriptor<com.ing.ipa.person.PersonDeleteRequest, com.ing.ipa.person.PersonDeleteResponse> getDeletePersonMethod;
    if ((getDeletePersonMethod = PersonServiceGrpc.getDeletePersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getDeletePersonMethod = PersonServiceGrpc.getDeletePersonMethod) == null) {
          PersonServiceGrpc.getDeletePersonMethod = getDeletePersonMethod = 
              io.grpc.MethodDescriptor.<com.ing.ipa.person.PersonDeleteRequest, com.ing.ipa.person.PersonDeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "person.PersonService", "DeletePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ing.ipa.person.PersonDeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ing.ipa.person.PersonDeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("DeletePerson"))
                  .build();
          }
        }
     }
     return getDeletePersonMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonServiceStub newStub(io.grpc.Channel channel) {
    return new PersonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PersonServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void getPerson(com.ing.ipa.person.PersonGetRequest request,
        io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonGetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPersonMethodHelper(), responseObserver);
    }

    /**
     */
    public void setPerson(com.ing.ipa.person.PersonSetRequest request,
        io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonSetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetPersonMethodHelper(), responseObserver);
    }

    /**
     */
    public void deletePerson(com.ing.ipa.person.PersonDeleteRequest request,
        io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonDeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeletePersonMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPersonMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ing.ipa.person.PersonGetRequest,
                com.ing.ipa.person.PersonGetResponse>(
                  this, METHODID_GET_PERSON)))
          .addMethod(
            getSetPersonMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ing.ipa.person.PersonSetRequest,
                com.ing.ipa.person.PersonSetResponse>(
                  this, METHODID_SET_PERSON)))
          .addMethod(
            getDeletePersonMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ing.ipa.person.PersonDeleteRequest,
                com.ing.ipa.person.PersonDeleteResponse>(
                  this, METHODID_DELETE_PERSON)))
          .build();
    }
  }

  /**
   */
  public static final class PersonServiceStub extends io.grpc.stub.AbstractStub<PersonServiceStub> {
    private PersonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void getPerson(com.ing.ipa.person.PersonGetRequest request,
        io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonGetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPersonMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setPerson(com.ing.ipa.person.PersonSetRequest request,
        io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonSetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetPersonMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deletePerson(com.ing.ipa.person.PersonDeleteRequest request,
        io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonDeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeletePersonMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PersonServiceBlockingStub extends io.grpc.stub.AbstractStub<PersonServiceBlockingStub> {
    private PersonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.ing.ipa.person.PersonGetResponse getPerson(com.ing.ipa.person.PersonGetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPersonMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ing.ipa.person.PersonSetResponse setPerson(com.ing.ipa.person.PersonSetRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetPersonMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ing.ipa.person.PersonDeleteResponse deletePerson(com.ing.ipa.person.PersonDeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeletePersonMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PersonServiceFutureStub extends io.grpc.stub.AbstractStub<PersonServiceFutureStub> {
    private PersonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ing.ipa.person.PersonGetResponse> getPerson(
        com.ing.ipa.person.PersonGetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPersonMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ing.ipa.person.PersonSetResponse> setPerson(
        com.ing.ipa.person.PersonSetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetPersonMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ing.ipa.person.PersonDeleteResponse> deletePerson(
        com.ing.ipa.person.PersonDeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeletePersonMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PERSON = 0;
  private static final int METHODID_SET_PERSON = 1;
  private static final int METHODID_DELETE_PERSON = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PERSON:
          serviceImpl.getPerson((com.ing.ipa.person.PersonGetRequest) request,
              (io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonGetResponse>) responseObserver);
          break;
        case METHODID_SET_PERSON:
          serviceImpl.setPerson((com.ing.ipa.person.PersonSetRequest) request,
              (io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonSetResponse>) responseObserver);
          break;
        case METHODID_DELETE_PERSON:
          serviceImpl.deletePerson((com.ing.ipa.person.PersonDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.ing.ipa.person.PersonDeleteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ing.ipa.person.PersonOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonService");
    }
  }

  private static final class PersonServiceFileDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier {
    PersonServiceFileDescriptorSupplier() {}
  }

  private static final class PersonServiceMethodDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PersonServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonServiceFileDescriptorSupplier())
              .addMethod(getGetPersonMethodHelper())
              .addMethod(getSetPersonMethodHelper())
              .addMethod(getDeletePersonMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
