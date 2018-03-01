package com.example.babul.calculatortest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView randomNumberTextView, scoreTextView;
    private ImageButton changeButton;
    private GridView gridView, buttonGridView;
    private Integer number = 0;
    private Map<Integer, String> map;
    String oWord = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumberTextView = findViewById(R.id.randomNumberId);
        changeButton = findViewById(R.id.changeButtonId);
        scoreTextView = findViewById(R.id.scoreTextViewId);
        gridView = findViewById(R.id.gridViewId);
        buttonGridView = findViewById(R.id.buttonGridViewId);

        number = generateRandomNumber();
        map = new HashMap<>();


        map.put(1,"ONE");
        map.put(2,"TWO");
        map.put(3,"THREE");
        map.put(4,"FOUR");
        map.put(5,"FIVE");
        map.put(6,"SIX");
        map.put(7,"SEVEN");
        map.put(8,"EIGHT");
        map.put(9,"NINE");
        map.put(10,"TEN");
        map.put(11,"ELEVENT");
        map.put(12,"TWELVE");
        map.put(13,"THIRTEEN");
        map.put(14,"FOURTEEN");
        map.put(15,"FIFTEEN");
        map.put(16,"SIXTEEN");
        map.put(17,"SEVENTEEN");
        map.put(18,"EIGHTEEN");
        map.put(19,"NINTEEN");
        map.put(20,"TWENTY");
        map.put(21,"TWENTYONE");
        map.put(22,"TWENTYTWO");
        map.put(23,"TWENTYTHREE");
        map.put(24,"TWENTYFOUR");
        map.put(25,"TWENTYFIVE");
        map.put(26,"TWENTYSIX");
        map.put(27,"TWENTYSEVEN");
        map.put(28,"TWENTYEIGHT");
        map.put(29,"TWENTYNINE");
        map.put(30,"THIRTY");
        map.put(31,"THIRTYONE");
        map.put(32,"THIRTYTWO");
        map.put(33,"THIRTYTHREE");
        map.put(34,"THIRTYFOUR");
        map.put(35,"THIRTYFIVE");
        map.put(36,"THIRTYSIX");
        map.put(37,"THIRTYSEVEN");
        map.put(38,"THIRTYEIGHT");
        map.put(39,"THIRTYNINE");
        map.put(40,"FOURTY");
        map.put(41,"FOURTYONE");
        map.put(42,"FOURTYTWO");
        map.put(43,"FOURTYTHREE");
        map.put(44,"FOURTYFOUR");
        map.put(45,"FOURTYFIVE");
        map.put(46,"FOURTYSIX");
        map.put(47,"FOURTYSEVEN");
        map.put(48,"FOURTYEIGHT");
        map.put(49,"FOURTYNINE");
        map.put(50,"FIFTY");
        map.put(51,"FIFTYONE");
        map.put(52,"FIFTYTWO");
        map.put(53,"FIFTYTHREE");
        map.put(54,"FIFTYFOUR");
        map.put(55,"FIFTYFIVE");
        map.put(56,"FIFTYSIX");
        map.put(57,"FIFTYSEVEN");
        map.put(58,"FIFTYEIGHT");
        map.put(59,"FIFTYNINE");
        map.put(60,"SIXTY");
        map.put(61,"SIXTYONE");
        map.put(62,"SIXTYTWO");
        map.put(63,"SIXTYTHREE");
        map.put(64,"SIXTYFOUR");
        map.put(65,"SIXTYFIVE");
        map.put(66,"SIXTYSIX");
        map.put(67,"SIXTYSEVEN");
        map.put(68,"SIXTYEIGHT");
        map.put(69,"SIXTYNINE");
        map.put(70,"SEVENTY");
        map.put(71,"SEVENTYONE");
        map.put(72,"SEVENTYTWO");
        map.put(73,"SEVENTYTHREE");
        map.put(74,"SEVENTYFOUR");
        map.put(75,"SEVENTYFIVE");
        map.put(76,"SEVENTYSIX");
        map.put(77,"SEVENTYSEVEN");
        map.put(78,"SEVENTYEIGHT");
        map.put(79,"SEVENTYNINE");
        map.put(80,"EIGHTY");
        map.put(81,"EIGHTYONE");
        map.put(82,"EIGHTYTWO");
        map.put(83,"EIGHTYTHREE");
        map.put(84,"EIGHTYFOUR");
        map.put(85,"EIGHTYFIVE");
        map.put(86,"EIGHTYSIX");
        map.put(87,"EIGHTYSEVEN");
        map.put(88,"EIGHTYEIGHT");
        map.put(89,"EIGHTYNINE");
        map.put(90,"NINTY");
        map.put(91,"NINTYONE");
        map.put(92,"NINTYTWO");
        map.put(93,"NINTYTHREE");
        map.put(94,"NINTYFOUR");
        map.put(95,"NINTYFIVE");
        map.put(96,"NINTYSIX");
        map.put(97,"NINTYSEVEN");
        map.put(98,"NINTYEIGHT");
        map.put(99,"NINTYNINE");


        changeGrid();

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number =  generateRandomNumber();
                randomNumberTextView.setText(number+"");
                changeGrid();
            }
        });

        buttonGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    private String[] getNames() {
        String names[] = new String[getLength()];

        for (int i=0; i<names.length; i++){
            names[i] = "";
        }
        return names;
    }

    public Integer generateRandomNumber(){
        Random random = new Random();
        int num = random.nextInt(100);
        return num;
    }


    public Integer getLength(){
        Integer length = null;
        for (Map.Entry m: map.entrySet()){
            Integer mKey = Integer.parseInt(m.getKey().toString());
            if (mKey.equals(number)){
                String nWord = m.getValue().toString();
                length = nWord.length();

                return length;
            }
        }
        return null;
    }

    public List getButtonLetterList(){
        List buttonLetterList = new ArrayList<>();
        for (Map.Entry m: map.entrySet()){
            Integer mKey = Integer.parseInt(m.getKey().toString());
            if (mKey.equals(number)){
                String nWord = m.getValue().toString();
                int nlength = nWord.length();
                int accurate = 13-nlength;

                Random rnd = new Random();

                StringBuilder sb = new StringBuilder(nWord);

                for (int i = 0; i<accurate; i++){
                    char c = (char) (rnd.nextInt(26) + 'a');
                    sb.append(c);
                    sb.reverse();
                }
                oWord = sb.toString();
                for (int i = 0; i<oWord.length(); i++){
                    buttonLetterList.add((oWord.charAt(i)));
                }

                return buttonLetterList;
            }
        }
        return null;
    }


    public void changeGrid(){
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.activity_simple,R.id.editTextId,getNames());
        gridView.setAdapter(adapter);


        ArrayAdapter buttonAdapter = new ArrayAdapter(MainActivity.this, R.layout.activity_button,R.id.buttonId,getButtonLetterList());
        buttonGridView.setAdapter(buttonAdapter);

        randomNumberTextView.setText(number+"");

    }


}
