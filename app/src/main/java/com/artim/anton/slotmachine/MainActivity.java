package com.artim.anton.slotmachine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView msg;
    private ImageView[][] IMGS = new ImageView[3][5];
    private Wheel[][] WHEELS = new Wheel[3][5];
    private Button btn;
    private boolean isStarted;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        IMGS[0][0] = (ImageView) findViewById(R.id.line0_img0);
        IMGS[0][1] = (ImageView) findViewById(R.id.line0_img1);
        IMGS[0][2] = (ImageView) findViewById(R.id.line0_img2);
        IMGS[0][3] = (ImageView) findViewById(R.id.line0_img3);
        IMGS[0][4] = (ImageView) findViewById(R.id.line0_img4);

        IMGS[1][0] = (ImageView) findViewById(R.id.line1_img0);
        IMGS[1][1] = (ImageView) findViewById(R.id.line1_img1);
        IMGS[1][2] = (ImageView) findViewById(R.id.line1_img2);
        IMGS[1][3] = (ImageView) findViewById(R.id.line1_img3);
        IMGS[1][4] = (ImageView) findViewById(R.id.line1_img4);

        IMGS[2][0] = (ImageView) findViewById(R.id.line2_img0);
        IMGS[2][1] = (ImageView) findViewById(R.id.line2_img1);
        IMGS[2][2] = (ImageView) findViewById(R.id.line2_img2);
        IMGS[2][3] = (ImageView) findViewById(R.id.line2_img3);
        IMGS[2][4] = (ImageView) findViewById(R.id.line2_img4);

        btn = (Button) findViewById(R.id.btn);
        msg = (TextView) findViewById(R.id.msg);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (isStarted) {
                        WHEELS[0][0].stopWheel();
                        WHEELS[0][1].stopWheel();
                        WHEELS[0][2].stopWheel();
                        WHEELS[0][3].stopWheel();
                        WHEELS[0][4].stopWheel();

                        WHEELS[1][0].stopWheel();
                        WHEELS[1][1].stopWheel();
                        WHEELS[1][2].stopWheel();
                        WHEELS[1][3].stopWheel();
                        WHEELS[1][4].stopWheel();

                        WHEELS[2][0].stopWheel();
                        WHEELS[2][1].stopWheel();
                        WHEELS[2][2].stopWheel();
                        WHEELS[2][3].stopWheel();
                        WHEELS[2][4].stopWheel();

                        if (WHEELS[1][0].currentIndex == WHEELS[1][1].currentIndex && WHEELS[1][1].currentIndex == WHEELS[1][2].currentIndex
                                && WHEELS[1][2].currentIndex == WHEELS[1][3].currentIndex && WHEELS[1][3].currentIndex == WHEELS[1][4].currentIndex) {
                            msg.setText("You win the big prize");
                        } else if (WHEELS[1][0].currentIndex == WHEELS[1][1].currentIndex || WHEELS[1][1].currentIndex == WHEELS[1][2].currentIndex || WHEELS[1][2].currentIndex == WHEELS[1][3].currentIndex || WHEELS[1][3].currentIndex == WHEELS[1][4].currentIndex
                                || WHEELS[1][0].currentIndex == WHEELS[1][2].currentIndex || WHEELS[1][1].currentIndex == WHEELS[1][3].currentIndex || WHEELS[1][2].currentIndex == WHEELS[1][4].currentIndex
                                || WHEELS[1][0].currentIndex == WHEELS[1][3].currentIndex || WHEELS[1][1].currentIndex == WHEELS[1][4].currentIndex
                                || WHEELS[1][0].currentIndex == WHEELS[1][4].currentIndex) {
                            msg.setText("Little Prize");
                        } else {
                            msg.setText("You lose");
                        }

                        btn.setText("Start");
                        isStarted = false;

                    } else {

                        // first line

                        WHEELS[0][0] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[0][0].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(0, 200));

                        WHEELS[0][0].start();

                        WHEELS[0][1] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[0][1].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[0][1].start();

                        WHEELS[0][2] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[0][2].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[0][2].start();

                        WHEELS[0][3] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[0][3].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[0][3].start();

                        WHEELS[0][4] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[0][4].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[0][4].start();

                        // second line

                        WHEELS[1][0] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[1][0].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(0, 200));

                        WHEELS[1][0].start();

                        WHEELS[1][1] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[1][1].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[1][1].start();

                        WHEELS[1][2] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[1][2].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[1][2].start();

                        WHEELS[1][3] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[1][3].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[1][3].start();

                        WHEELS[1][4] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[1][4].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[1][4].start();

                        // third line

                        WHEELS[2][0] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[2][0].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(0, 200));

                        WHEELS[2][0].start();

                        WHEELS[2][1] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[2][1].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[2][1].start();

                        WHEELS[2][2] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[2][2].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[2][2].start();

                        WHEELS[2][3] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[2][3].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[2][3].start();

                        WHEELS[2][4] = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        IMGS[2][4].setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        WHEELS[2][4].start();

                        btn.setText("Stop");
                        msg.setText("");
                        isStarted = true;
                    }
            }
        });
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}
