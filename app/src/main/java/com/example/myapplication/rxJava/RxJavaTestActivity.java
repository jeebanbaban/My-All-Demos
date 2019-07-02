package com.example.myapplication.rxJava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class RxJavaTestActivity extends AppCompatActivity{

    Observable<List<Student>> studentObservables;
    Observer<List<Student>> studentObserver;
    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_test);

        //OBSERVABLE
        studentObservables=getStudentObsrevableList();

        //OBSERVER
        studentObserver=getStudentObserver();

    }

    private List<Student> getStudents() {
        List<Student> students=new ArrayList<>();

        students.add(new Student("Jeeban",1));
        students.add(new Student("Asif",2));
        students.add(new Student("Sudhir",3));
        students.add(new Student("Rituparna",4));

        return students;
    }

    private Observable<List<Student>> getStudentObsrevableList(){
        return Observable.just(getStudents());
    }

    private Observer<List<Student>> getStudentObserver(){
        return new Observer<List<Student>>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable=d;
                System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSS  onSubscribe");
            }

            @Override
            public void onNext(List<Student> students) {
                System.out.println("students= "+students);
                System.out.println("students size= "+students.size());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEE  onError="+e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("CCCCCCCCCCCCCCCCCCCCCCCC  onComplete");
            }
        };
    }

    private void subscribeStudentObservable(){
        //Observer subscribing to the Observable
        studentObservables
                .subscribeOn(Schedulers.io())//This tell the Observable to run the task on a background thread.
                .observeOn(AndroidSchedulers.mainThread())//This tells the Observer to receive the data on android UI thread so that you can take any UI related actions.
                .filter(new Predicate<List<Student>>() {
                    @Override
                    public boolean test(List<Student> students) throws Exception {
                        for (Student s :students){
                            if (s.getRoll_no()==2){
                                System.out.println("name=" +s.getName());
                                //return true;
                            }
                        }
                        return false;
                    }
                })
                .subscribe(studentObserver);
    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnShowStudents:
                subscribeStudentObservable();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
