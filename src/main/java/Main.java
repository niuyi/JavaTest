import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by niuyi on 2017/3/23.
 */

public class Main {
    public static void main(String args[]){

        byte[] bytes = Transfer.intToByteArray(1000);
        System.out.println(Arrays.toString(bytes));

        bytes = new byte[]{0, 0,3, -24};

        System.out.println(Transfer.byteArrayToInt(bytes));
        System.out.println(Transfer.revert("abcdef"));
        System.out.println(Transfer.checkReverse("abcdef", "fedcbb"));
        Transfer.permutation("abc");

        System.out.println(Transfer.stringToInt("123"));
//        byte b = 127;
//        System.out.print(new byte[b, b, b, b]);

//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher("hello123nihao");
//        while(matcher.find()){
//            System. out.println(matcher.group(0));
//        }

//        ArrayList<String> list = new ArrayList<>();
//        for(int i = 0 ; i < 10 ; i++){
//            list.add(String.valueOf(i));
//        }
//
////        for(String s : list){
////            if(s.equalsIgnoreCase("3")){
////                list.remove(s);
////            }
////        }
//
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            String s = it.next();
//            if(s.equalsIgnoreCase("3")){
//                it.remove();
//            }
//        }
//
//        for(String s : list){
//            System. out.println(s);
//        }

//        for(Iterator<String> it = list.iterator(); it.hasNext() ; ){
//            String s = it.next();
//            System. out.println(s);
//        }


//        Semaphore sem = new Semaphore(3);
//        for(int i = 0 ; i < 5 ; i++){
//            try {
//                sem.acquire();
//            } catch (InterruptedException e ) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            System. out.println("acquire" );
//        }

//        Sort.mergeSortTest();

//        Graph.dfsTest();

//
//        TreeSet<String> set = new TreeSet<>();
//        set.add("a");
//        set.add("c");
//        set.add("b");
//
//        for(String s : set){
//            System.out.println(s);
//        }
//
//
//        LinkedHashSet<String> set2 = new LinkedHashSet<>();
//        set2.add("a");
//        set2.add("c");
//        set2.add("b");
//
//        for(String s : set2){
//            System.out.println(s);
//        }


//        List<Fruit> flist = new ArrayList<Fruit>();
//
//        flist.add(new Apple());
//        flist.add(new Banana());
//
//        List<Apple> aList = new ArrayList<Apple>();
//        List<Banana> bList = new ArrayList<Banana>();
//
//        aList.add(new Apple());
//        bList.add(new Banana());
//
////        flist = aList; //编译错误
//
//        List<? extends Fruit> fList2 = new ArrayList<>();
////        fList2.add(new Apple());//编译错误
////        fList2.add(new Banana());//编译错误
//
////        aList = fList2; //编译错误
//        fList2 = aList; //pass!
//        Fruit fruit = fList2.get(0);//pass
//
//
//        List<? super Apple> aList2 = new ArrayList<>();
//        aList2.add(new Apple()); //pass
////        aList2.add(new Fruit());//编译错误
//        Object object = aList2.get(0);//不知道是什么类型，只能是object
//
//        aList2 = aList; //pass
//        aList = aList2; //编译错误

//        String[] split = "xiaomi\\xxxx".split("\\\\");
//        System.out.println(split.length);
//        System.out.println(split[0]);
//        Flowable.just("Hello world").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.print(s);
//            }
//        });
//
//        System.out.println("mian call1: " + Thread.currentThread().getId());
//
//        Flowable<String> source = Flowable.fromCallable(() -> {
//            Thread.sleep(1000); //  imitate expensive computation
//            System.out.println("call1: " + Thread.currentThread().getId());
//            return "Done";
//        });
//
//        Flowable<String> back = source.subscribeOn(Schedulers.io());
//        back.observeOn(Schedulers.newThread()).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Thread.sleep(1000); //
//                System.out.println(s);
//                System.out.println("call2: " + Thread.currentThread().getId());
//            }
//        });
////        Flowable<String> fore = back.subscribeOn(Schedulers.single());
////        fore.subscribe(new Consumer<String>() {
////            @Override
////            public void accept(String s) throws Exception {
////                System.out.println(s);
////                System.out.println("call2: " + Thread.currentThread().getId());
////            }
////        }, new Consumer<Throwable>() {
////            @Override
////            public void accept(Throwable throwable) throws Exception {
////                throwable.printStackTrace();
////            }
////        });
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Flowable<Integer> map = Flowable.range(1, 10).observeOn(Schedulers.computation()).map();
//        map.blockingSubscribe(System.out::print);
//
//        Flowable.range(1, 10)
//                .flatMap(v ->
//                        Flowable.just(v)
//                                .subscribeOn(Schedulers.computation())
//                                .map(w -> w * w)
//                )
//                .blockingSubscribe(System.out::println);


//
//        Observable<Void> a = Observable.create(new ObservableOnSubscribe<Void>() {
//            @Override
//            public void subscribe(ObservableEmitter<Void> e) throws Exception {
//                e.onComplete();
//                e.onNext(null);
//            }
//        });
//
//
//        Observable<String> b = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("b");
//                e.onComplete();
//            }
//        });
//
//        Observable<Integer> c = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(10);
//            }
//        });



//        Observable.concat(a, b, c).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println(s);
//            }
//        });


//        List<String> list = new ArrayList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");

//
//        Observable.fromArray(list).flatMap(new Function<List<String>, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(List<String> strings) throws Exception {
//                return null;
//            }
//        }).filter(new Func1<File,Boolean>(){});

//        Observable.just(list).first().subscribe(new SingleOnSubscribe<>() {
//            @Override
//            public void subscribe(SingleEmitter e) throws Exception {
//
//            }
//        });
    }


}
