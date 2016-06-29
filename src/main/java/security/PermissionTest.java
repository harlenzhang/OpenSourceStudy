package security;

import java.io.File;
import java.io.FilePermission;
import java.security.AccessController;
import java.security.Permission;

/**
 * Created by harlenzhang on 16/6/29.
 */
public class PermissionTest {
    public static void main(String[] args) {
        char sep = '/';
        Permission file = new FilePermission(sep + "Users"+ sep + "harlenzhang" + sep + "rmq_bk_gc.log", "write");
        Permission star = new FilePermission(sep + "Users" + sep +"harlenzhang" +  sep + "*", "write, read");
        System.out.println(star.implies(file));
        System.out.println(file.getName());
        System.out.println(file.implies(star));

        System.out.println(file.getActions());
        System.out.println(star.getActions());
        Thread.currentThread().setDaemon(true);
    }
}
