package com.jd.ssm.rx;

import com.jd.ssm.jdk8.Person;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by wangyingjie1 on 2017/2/6.
 */
public class RxJavaTest {

    /**
     * map: Person -> id(String)
     * 打印某个人id
     */
    @Test
    public void testMap0() {
        Observable.just(getPersonArray()[0])
                .map(new Func1<Person, String>() {
                    @Override
                    public String call(Person person) {
                        return person.id;
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String id) {
                        System.out.println("xxxxxxxxxxxx======" + id);
                    }
                });
    }

    /**
     * map: array Person -> id(String)
     * 打印每个人的id
     */
    @Test
    public void testMap() {
        Observable.from(getPersonArray())
                .map(new Func1<Person, String>() {
                    @Override
                    public String call(Person person) {
                        return person.id;
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String id) {
                        System.out.println("xxxxxxxxxxxx======" + id);
                    }
                });
    }

    /**
     * flatMap: array Person -> email数组（String[]）
     * 打印每个人的所有email
     */
    public void testFlatMap() {
        /*Observable.from(getPersonArray())
                .flatMap(new Func1<Person, Observable<Person.Email>>() {
                    @Override
                    public Observable<Person.Email> call(Person person) {
                        Log.d(TAG, "flatMap " + person.id);
                        return Observable.from(person.emails);
                    }
                })
                .subscribe(new Subscriber<Person.Email>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Person.Email email) {
                        Log.d(TAG, "onNext " + email.name);
                    }
                });*/
    }

    public Person[] getPersonArray() {
        Person person1 = new Person();
        person1.setId("1111");

        Person person2 = new Person();
        person2.setId("222222");

        Person[] person = {person1, person2};

        return person;
    }

    @Test
    public void testRx() {
        Observable.just("#Basic Markdown to HTML").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                if (s != null && s.startsWith("#")) {
                    return "<h1>" + s.substring(1, s.length()) + "</h1>";
                }
                return null;
            }
        }).subscribe(s -> System.out.println(s));


        Observable.just("#Basic Markdown to HTML").map(s -> s != null && s.startsWith("#") ? "<h1>" + s.substring(1, s.length()) + "</h1>" : null)
                .subscribe(s -> System.out.println(s));

        Observable.just("#Basic Markdown to HTML").map(s -> s != null && s.startsWith("#") ? "<h1>" + s.substring(1, s.length()) + "</h1>" : null)
                .subscribe(System.out::println);
    }

    @Test
    public void testRx1() {
        Observable.just(0, 1, 2, 3, 4).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.print(integer);
            }
        });
        System.out.println();
        Observable.just(0, 1, 2, 3, 4).subscribe(System.out::print);
    }

    @Test
    public void testRx2() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onStart();
                        for (int i = 0; i < 5; i++) {
                            subscriber.onNext(i);
                        }
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onStart() {
                System.out.println("start");
            }

            @Override
            public void onCompleted() {
                System.out.println("complete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    @Test
    public void testThread() {
        //subscribeOn(Schedulers.io());

        Scheduler.Worker worker = Schedulers.newThread().createWorker();
        worker.schedule(new Action0() {

            @Override
            public void call() {
                dowork();
            }

            private void dowork() {
                System.out.println("xxxxxxxxxxxxxxxxx");
            }

        });

        // some time later...
        worker.unsubscribe();
    }


    @Test
    public void testThread2() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("xxxxxxxxxxxxxxxxx");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("xxxxxxxxxxxxxxxxx");
            }

            @Override
            public void onNext(String s) {
                System.out.println("xxxxxxxxxxxxxxxxx");
            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("yy");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("yyyyyyyy");
            }

            @Override
            public void onNext(String s) {
                System.out.println("yyyyyyyyy");
            }
        };

        //Observable observable = new Observable();
        //observable.subscribe(subscriber);

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //Log.d(TAG, "OnSubscribe.call Thread -> " + Thread.currentThread().getName());
                subscriber.onNext("message");
            }
        }).subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        /// Log.d(TAG, "Subscriber.onNext Thread -> " + Thread.currentThread().getName());
                    }
                });

        // Observable.subscribe(subscriber);
        //Observable.subscribe(Action)

        /*Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("message 1");
                subscriber.onNext("message 2");
                subscriber.onCompleted();
            }
        });*/
    }

    @Test
    public void test() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }
        };
        myObservable.subscribe(mySubscriber);

    }


    @Test
    public void test2() {

        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );

        Observable.just("Hello, world!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

    }
}
