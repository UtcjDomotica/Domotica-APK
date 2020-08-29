package com.UTCJ.domotica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.UTCJ.domotica.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refLuces = database.getReference("Aparatos");
    DatabaseReference  refRele_7, refRele_8, refRele_6, refRele_5, refRele_4, refRele_3, refRele_2, refRele_1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        refRele_8 = refLuces.child("Rele_8");
        refRele_7 = refLuces.child("Rele_7");
        refRele_6 = refLuces.child("Rele_6");
        refRele_5 = refLuces.child("Rele_5");
        refRele_4 = refLuces.child("Rele_4");
        refRele_3 = refLuces.child("Rele_3");
        refRele_2 = refLuces.child("Rele_2");
        refRele_1 = refLuces.child("Rele_1");

        Switch  ToggleButton8 = (Switch) root.findViewById(R.id.switch1);
        Switch  ToggleButton7 = (Switch) root.findViewById(R.id.switch2);
        Switch  ToggleButton6 = (Switch) root.findViewById(R.id.switch3);
        Switch  ToggleButton5 = (Switch) root.findViewById(R.id.switch4);
        Switch  ToggleButton4 = (Switch) root.findViewById(R.id.switch5);
        Switch  ToggleButton3 = (Switch) root.findViewById(R.id.switch6);
        Switch  ToggleButton2 = (Switch) root.findViewById(R.id.switch7);
        Switch  ToggleButton1 = (Switch) root.findViewById(R.id.switch8);

        control8(refRele_8,ToggleButton8);
        control7(refRele_7,ToggleButton7);
        control6(refRele_6,ToggleButton6);
        control5(refRele_5,ToggleButton5);
        control4(refRele_4,ToggleButton4);
        control3(refRele_3,ToggleButton3);
        control2(refRele_2,ToggleButton2);
        control1(refRele_1,ToggleButton1);
        return root;


    }
    private void control7(final DatabaseReference refLed, final Switch toggle_btn7 ) {

        toggle_btn7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed.setValue(isChecked);
            }
        });

        refLed.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led  = (Boolean) dataSnapshot.getValue();
                toggle_btn7.setChecked(estado_led);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }
    private void control8(final DatabaseReference refLed8, final Switch toggle_btn8 ) {

        toggle_btn8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed8.setValue(isChecked);
            }
        });

        refLed8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led8  = (Boolean) dataSnapshot.getValue();
                toggle_btn8.setChecked(estado_led8);

        }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }


    private void control6(final DatabaseReference refLed6, final Switch toggle_btn6 ) {

        toggle_btn6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed6.setValue(isChecked);
            }
        });

        refLed6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led6  = (Boolean) dataSnapshot.getValue();
                toggle_btn6.setChecked(estado_led6);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }


    private void control5(final DatabaseReference refLed5, final Switch toggle_btn5 ) {

        toggle_btn5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed5.setValue(isChecked);
            }
        });

        refLed5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led5  = (Boolean) dataSnapshot.getValue();
                toggle_btn5.setChecked(estado_led5);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }

    private void control4(final DatabaseReference refLed4, final Switch toggle_btn4 ) {

        toggle_btn4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed4.setValue(isChecked);
            }
        });

        refLed4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led4  = (Boolean) dataSnapshot.getValue();
                toggle_btn4.setChecked(estado_led4);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }

    private void control3(final DatabaseReference refLed3, final Switch toggle_btn3 ) {

        toggle_btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed3.setValue(isChecked);
            }
        });

        refLed3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led3  = (Boolean) dataSnapshot.getValue();
                toggle_btn3.setChecked(estado_led3);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }

    private void control2(final DatabaseReference refLed2, final Switch toggle_btn2 ) {

        toggle_btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed2.setValue(isChecked);
            }
        });

        refLed2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led2  = (Boolean) dataSnapshot.getValue();
                toggle_btn2.setChecked(estado_led2);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }

    private void control1(final DatabaseReference refLed1, final Switch toggle_btn1 ) {

        toggle_btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                refLed1.setValue(isChecked);
            }
        });

        refLed1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean estado_led1  = (Boolean) dataSnapshot.getValue();
                toggle_btn1.setChecked(estado_led1);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }

        });
    }
}
