package base;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class PreconditionsDrill {
    public static void main(String[] args) {
        PreconditionsDrill.checkArgument();
        PreconditionsDrill.checkNotNull();
        PreconditionsDrill.checkPositionIndex();
    }

    public static void checkArgument(){
        int age = 28;
        Preconditions.checkArgument(age>27,"age must over 29",age);
    }

    public static void checkNotNull(){
        String msg = "not null";
        String rightMsg = Preconditions.checkNotNull(msg,"msg should not be null",msg);
        System.out.println(rightMsg);
    }

    public static void checkPositionIndex(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int index =3;
        int rightIndex = Preconditions.checkPositionIndex(index, list.size(), "index "+index+" not in list, List size："+list.size());
        System.out.println(rightIndex);
    }
}
