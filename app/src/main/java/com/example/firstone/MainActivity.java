package com.example.firstone;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, eq, cl, add, sub, mul, div,c;
    ImageButton sett;
    EditText e1;
    double num1, num2, s, m, d;
    double a = s = m = d = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        n1 = findViewById(R.id.b1);
        n2 = findViewById(R.id.b2);
        n3 = findViewById(R.id.b3);
        n4 = findViewById(R.id.b4);
        n5 = findViewById(R.id.b5);
        n6 = findViewById(R.id.b6);
        n7 = findViewById(R.id.b7);
        n8 = findViewById(R.id.b8);
        n9 = findViewById(R.id.b9);
        n0 = findViewById(R.id.b0);
        cl = findViewById(R.id.clear);
        e1 = findViewById(R.id.tbox);
        add = findViewById(R.id.addition);
        sub = findViewById(R.id.subtraction);
        mul = findViewById(R.id.multiplication);
        div = findViewById(R.id.division);
        eq = findViewById(R.id.equal);
        sett = findViewById(R.id.fab_key);
        c=findViewById(R.id.c);


        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "1");
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "2");
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "3");
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "4");
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "5");
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "6");
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "7");
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "8");
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "9");
            }
        });
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "0");
            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == 0) {
                    num2 = Double.parseDouble(e1.getText() + "");
                    e1.setText((num1 + num2) + "");
                    a = 1;
                }
                if (s == 0) {
                    num2 = Double.parseDouble(e1.getText() + "");
                    e1.setText((num1 - num2) + "");
                    s = 1;
                }
                if (m == 0) {
                    num2 = Double.parseDouble(e1.getText() + "");
                    e1.setText((num1 * num2) + "");
                    m = 1;
                }
                if (d == 0) {
                    num2 = Double.parseDouble(e1.getText() + "");
                    e1.setText((num1 / num2) + "");
                    d = 1;
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(e1.getText() + "");
                e1.setText("");
                a = 0;
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(e1.getText() + "");
                e1.setText("");
                s = 0;
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(e1.getText() + "");
                e1.setText("");
                m = 0;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(e1.getText() + "");
                e1.setText("");
                d = 0;
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= e1.getText().toString();
                if(s.length()>=1) {
                    String str = s.substring(0, s.length() - 1);
                    e1.setText(str);
                }
                else {
                        e1.setText("");
                }
            }
        });
        sett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, sett);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        if(item.getTitle().toString().compareTo("Chess Timer")==0)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Set Time for Play");

                            final EditText ed=new EditText(MainActivity.this);
                            ed.setInputType(InputType.TYPE_CLASS_NUMBER);
                            builder.setView(ed);

                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i=new Intent(getApplicationContext(),Chess.class);

                                    i.putExtra("Time",ed.getText().toString());
                                    startActivity(i);
                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
                                }
                            });
                            builder.show();
                        }
                        if(item.getTitle().toString().compareTo("Math Game")==0)
                        {
                            Intent i=new Intent(getApplicationContext(),Game_Splash.class);
                            startActivity(i);
                        }
                        return true;
                    }
                });
                popup.show();
            }


        });
    }
}