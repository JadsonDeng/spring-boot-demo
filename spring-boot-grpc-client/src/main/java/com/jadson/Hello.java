// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Hello.proto

package com.jadson;

public final class Hello {
  private Hello() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_jadson_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_jadson_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_jadson_Greeting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_jadson_Greeting_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013Hello.proto\022\ncom.jadson\"\'\n\006Person\022\020\n\010u" +
      "sername\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\"\033\n\010Greeting\022\017" +
      "\n\007message\030\001 \001(\t2D\n\014HelloService\0224\n\010sayHe" +
      "llo\022\022.com.jadson.Person\032\024.com.jadson.Gre" +
      "etingB\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_jadson_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_jadson_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_jadson_Person_descriptor,
        new java.lang.String[] { "Username", "Age", });
    internal_static_com_jadson_Greeting_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_jadson_Greeting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_jadson_Greeting_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
