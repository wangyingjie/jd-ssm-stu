package com.jd.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class JDClassLoader extends ClassLoader {

    private File classPathFile;

    public JDClassLoader() {
        String classPath = JDClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }


    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String className = JDClassLoader.class.getPackage().getName() + "." + name;

        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;

                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        // class file write to jvm
                        out.write(buff, 0, len);
                    }
                    // define class
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != in) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

        return null;

    }
}
