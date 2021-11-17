package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    // maintains list of subscriptions in a pool and can dispose them all at once.
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compositeDisposable.add((Disposable) getNotepadObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Notepad>() {//Observer that listen to Observable.

                    //This method will be called when Observable starts emitting the data.
                    @Override
                    public void onNext(Notepad notepad) {
                        Log.d("Items in notepad",notepad.getNote_data());

                    }
                    //n case of any error, onError() method will be called.
                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error","Error while fetching notepad"+e.getMessage());

                    }
                    //When an Observable completes the emission of all the items, onComplete() will be called.
                    @Override
                    public void onComplete() {
                        Log.d("SUCCESS","All data in notepad is shown");

                    }
                }));

    }

    //Observable is something that emits data.
    private Observable getNotepadObservable() {
        final List<Notepad> notes = createNotes();

        return Observable.create(new ObservableOnSubscribe<Notepad>() {
            @Override
            public void subscribe(ObservableEmitter<Notepad> emitter) throws Exception {
                for (Notepad note : notes) {
                    if (!emitter.isDisposed()) {
                        emitter.onNext(note);
                    }
                }

                if (!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });


    }


    private List<Notepad> createNotes(){

        List<Notepad> notepad_data = new ArrayList();
        notepad_data.add(new Notepad(1,"Send email to Chacko"));
        notepad_data.add(new Notepad(2,"Prepare for retrospective meeting"));
        notepad_data.add(new Notepad(3,"Backlog refinement"));
        notepad_data.add(new Notepad(4,"Assign tickets"));
        return notepad_data;

    }
    class Notepad {

        int id;
        String note_data;
        public Notepad(int id,String note_data){
            this.id=id;
            this.note_data= note_data;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNote_data() {
            return note_data;
        }

        public void setNote_data(String note_data) {
            this.note_data = note_data;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //disposing lists all at once in destroy method
        compositeDisposable.clear();
    }
}

