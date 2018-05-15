package priv.interview.module.algorithm.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 遍历删除一个元素
 */
public class Sample1 {

    public static boolean delElementFail() {
        List<Integer> list = Arrays.asList(new Integer[]{11, 22});

        Iterator<Integer> iterator = list.iterator();
        System.out.println(list);
        try {
            while (iterator.hasNext()) {
                Integer item = iterator.next();
                if (11 == item) {
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            return false;
        }


        System.out.println(list);
        return true;
    }

    public static boolean delElementFail2() {
        List<Integer> list = Arrays.asList(new Integer[]{11, 22});

        try {
            for (Integer ele : list) {
                if (ele == 11)
                    list.remove(ele);
            }
        } catch (Exception e) {
            return false;
        }

        System.out.println(list);
        return true;
    }

    public static boolean delElementFail3() {
        List<Integer> list = new CopyOnWriteArrayList<>(); //Arrays.asList(new Integer[]{11, 22});
        list.add(11);
        list.add(22);
        Iterator<Integer> iterator = list.iterator();
        try {
            while (iterator.hasNext()) {
                if (iterator.next() == 11) {
                    iterator.remove();
                }
            }
        } catch (Exception ex) {
            return false;
        }
        System.out.println(list);
        return true;
    }


    public static boolean delElementSuccess() {

        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(list);

        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (11 == item) {
                iterator.remove();
            }
        }
        System.out.println(list);
        return true;
    }


    public static boolean delElementSuccess2() {

        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        for (Integer item : list) {
            if (item == 11)
                list.remove(item);
        }

        System.out.println(list);
        return true;
    }

    public static boolean delElementSuccess4() {
        List<Integer> list = new CopyOnWriteArrayList<>(); //Arrays.asList(new Integer[]{11, 22});
        list.add(11);
        list.add(22);
        for (Integer ele : list) {
            if (ele == 11)
                list.remove(ele);
        }
        System.out.println(list);
        return true;
    }


    public static void main(String[] args) {
        System.out.println(delElementFail());

        System.out.println(delElementFail2());

        System.out.println(delElementFail3());

        System.out.println(delElementSuccess());

        System.out.println(delElementSuccess2());

        System.out.println(delElementSuccess4());

    }
}





