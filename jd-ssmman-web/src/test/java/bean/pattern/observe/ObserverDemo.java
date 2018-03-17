package bean.pattern.observe;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.LongAdder;

/**
 * @desc 观察者模式
 * @author: wangyingjie1
 * @date: ${date}
 */
public class ObserverDemo {

    public static void main(String[] args) {

        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < 10; i++) {
            longAdder.add(10);
        }
        System.out.println(longAdder.longValue());

        // 观察者模式 三步曲
        MyObservable observable = new MyObservable();

        // 添加观察者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("observer 1 =================");
            }
        });
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("observer 2 =================");
            }
        });
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("observer 3 =================");
            }
        });

        // 调整变化
        observable.setChanged();

        // 通知变化
        observable.notifyObservers();
    }

    private static class MyObservable extends Observable {

        /**
         * 扩展父类接口的访问权限
         */
        @Override
        public synchronized void setChanged() {
            // protected
            super.setChanged();
        }
    }
}
