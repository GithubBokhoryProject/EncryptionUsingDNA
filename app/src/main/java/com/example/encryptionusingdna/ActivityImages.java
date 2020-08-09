package com.example.encryptionusingdna;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.ListView;

        import java.util.ArrayList;

public class ActivityImages extends AppCompatActivity {
    ListView listView;
    ArrayList<User> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        listView=findViewById(R.id.listview_id);
        arrayList=new ArrayList<>();
        arrayList.add(new User(R.drawable.img1));
        arrayList.add(new User(R.drawable.img2));
        arrayList.add(new User(R.drawable.img3));
        arrayList.add(new User(R.drawable.img4));
        arrayList.add(new User(R.drawable.img5));
        arrayList.add(new User(R.drawable.img6));
        arrayList.add(new User(R.drawable.img7));
        arrayList.add(new User(R.drawable.img8));
        arrayList.add(new User(R.drawable.img9));
        UserAdabter adabter=new UserAdabter(ActivityImages.this,arrayList);
        listView.setAdapter(adabter);
    }
}
