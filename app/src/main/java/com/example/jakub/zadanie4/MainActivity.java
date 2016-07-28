package com.example.jakub.zadanie4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.image_imageView) ImageView mImageView;
    @BindView(R.id.name_TextView) TextView mTextView;

    private Subscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void init() {
        mSubscription = PersonService.getInstance().getResults(20)
                .map(PersonServiceResponse -> PersonServiceResponse.getResults())
                .flatMap(persons -> Observable.from(persons))
                .distinct()
                .filter(persons -> !persons.getName().getFirst().equals("dupa"))
                .take(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    setData(result);
                }, Throwable::printStackTrace);
    }

    public void setData(Result result) {

        Picasso.with(this).load(result.getPicture().getMedium()).into(mImageView);
        setAvatar(result.getName().getFirst(), result.getName().getLast());
        mTextView.setText(String.format("%s %s", result.getName().getFirst(), result.getName().getLast()));

    }


    public void setAvatar(String firstName, String lastName) {
        Picasso.with(MainActivity.this).load("https://api.adorable.io/avatars/120/"+firstName+"@"+lastName+".io.png").into(mImageView);
    }


}
