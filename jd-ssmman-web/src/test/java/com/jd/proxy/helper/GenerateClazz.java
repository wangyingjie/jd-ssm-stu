package com.jd.proxy.helper;

import com.jd.proxy.JDClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @desc
 * @author: wangyingjie1
 * @date: ${date}
 */
public class GenerateClazz {

    public static void generate(String srcCode) throws Exception {

        // Java file output to disk

        File file = getWriterJavaFile(srcCode);

        // Java file compiler .class file
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
        task.call();
        manager.close();

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");

        String className = "$Proxy0";
        JDClassLoader classLoader = new JDClassLoader();
        Class<?> proxyClazz = classLoader.findClass(className);
        Constructor<?>[] constructors = proxyClazz.getConstructors();

        Object instance = constructors[0].newInstance(null);

        Method[] methods = instance.getClass().getMethods();
        Arrays.stream(methods).forEach(method -> {
            try {
                System.out.println("methodName====" + method.getName());

                method.invoke(instance, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        System.out.println(instance);
    }

    private static File getWriterJavaFile(String srcCode) throws IOException {
        String path = GenerateClazz.class.getResource("").getPath();
        File file = new File(path + "$Proxy0.java");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(srcCode);
        fileWriter.flush();
        fileWriter.close();
        return file;
    }


    public static void main(String[] args) {
        String srcCode = getSrcCode();
        try {
            generate(srcCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getSrcCode() {
        return "package com.jd.proxy;\n" +
                "public class $Proxy0  implements JDInvocationHandler {\n" +
                "\n" +
                "    private int id;\n" +
                "    private int name;\n" +
                "\n" +
                "    public void call() {\n" +
                "        System.out.println(\"call who phone no\");\n" +
                "    }\n" +
                "\n" +
                "    public int getId() {\n" +
                "        return id;\n" +
                "    }\n" +
                "\n" +
                "    public void setId(int id) {\n" +
                "        this.id = id;\n" +
                "    }\n" +
                "\n" +
                "    public int getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(int name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "}\n";
    }
}
