package com.php.permissions;

/**
 *    desc   : 动态申请的权限没有在清单文件中注册会抛出的异常
 */
final class ManifestRegisterException extends RuntimeException {

    ManifestRegisterException(String permission) {
        super(permission == null ?
                "No permissions are registered in the manifest file" :
                (permission + ": Permissions are not registered in the manifest file"));
    }
}