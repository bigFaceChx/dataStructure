package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反编译
 */
public class fileds {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取字节码文件（类对象）
        Class<?> aClass = Class.forName("reflect.user");
        Field[] declaredFields = aClass.getDeclaredFields();
        /*for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }*/
        StringBuffer stringBuffer = new StringBuffer("public class "+aClass.getSimpleName()+"{");
        stringBuffer.append("\n");
        for (int i = 0; i < declaredFields.length; i++) {
            stringBuffer.append("\t").append(Modifier.toString(declaredFields[i].getModifiers())).
                         append(" ").append(declaredFields[i].getType().getSimpleName()).
                         append(" ").append(declaredFields[i].getName()).
                         append(";");
            stringBuffer.append("\n");
        }
        stringBuffer.append("}");
        System.out.println(stringBuffer.toString());

    }
}
