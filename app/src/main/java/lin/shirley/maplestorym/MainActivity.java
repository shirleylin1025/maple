package lin.shirley.maplestorym;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private int physicalAttack, magicAttack, critAttack;
    private double physicalAttackIncrease = 0;
    private double physicalDamageIncrease;
    private double magicAttackIncrease;
    private double magicDamageIncrease;
    private double bossAttackIncrease;
    private double playerAttackIncrease;
    private double critRate;
    private double critDamge;
    private TextView mPhysicalAttackTextView;
    private EditText mPhysicalAttackText, mPhysicalAttackIncreaseText, mPhysicalDamageIncreaseText, mMagicAttackText, mMagicAttackIncreaseText, mMagicDamageIncreaseText,
            mBossAttackIncreaseText,
            mPlayerAttackIncrease,
            mCritRate, mCritAttack, mCritDamge;
    private Button mSubmitBotton;

    private double mfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        mSubmitBotton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("".equals(mPhysicalAttackText.getText().toString().trim())) {
                    physicalAttack = 0;
                } else {
                    physicalAttack = Integer.parseInt(mPhysicalAttackText.getText().toString());
                }

                if ("".equals(mPhysicalAttackIncreaseText.getText().toString().trim())) {
                    physicalAttackIncrease = 0;
                } else {
                    physicalAttackIncrease = (Double.parseDouble(mPhysicalAttackIncreaseText.getText().toString())) * 1;
                    String.format("%.1f", physicalAttackIncrease);
                    physicalAttackIncrease++;
                }

                if ("".equals(mCritRate.getText().toString().trim())) {
                    critRate = 0;
                } else {
                    critRate = (Double.parseDouble(mCritRate.getText().toString())) * 0.01;
                    String.format("%.1f", critRate);
                }

                if ("".equals(mCritAttack.getText().toString().trim())) {
                    critAttack = 0;
                } else {
                    critAttack = Integer.parseInt(mPhysicalAttackText.getText().toString());
                }

                if ("".equals(mCritDamge.getText().toString().trim())) {
                    critDamge = 0;
                } else {
                    critDamge = (Double.parseDouble(mCritDamge.getText().toString())) * 1;
                    String.format("%.1f", critDamge);
                    critDamge++;
                }

                //physicalDamageIncrease = (Double.parseDouble(mPhysicalDamageIncreaseText.getText().toString()))*0.01;
                // ((1-致命攻擊率%) x (物理攻擊力 x 物理攻擊力% x 技能傷害) +致命攻擊率 x
                //        [(物理攻擊力 + 致命攻擊) x 物理攻擊力% x 致命攻擊傷害% x 技能傷害]) x 物理傷害增加%

                //mfinal = ((1-critRate)*(physicalAttack*physicalAttackIncrease*2.112)+critRate*((physicalAttack+critAttack)*physicalAttackIncrease*critDamge
                //*2.112))*physicalDamageIncrease;
                /*mfinal = ((1 - 0.101) * (2471 * 1.13 * 2.112) + 0.101 * ((2471 + 59) * 1.13 * 1.4
                        * 2.112)) * 1.15;*/

                Log.e("value:", mfinal + "");
            }
        });

    }

    private void findView() {
        mPhysicalAttackText = (EditText) findViewById(R.id.physicalAttack_editText);
        mPhysicalAttackTextView = (TextView) findViewById(R.id.physicalAttack_textView);
        mPhysicalAttackIncreaseText = (EditText) findViewById(R.id.physicalAttackIncrease_editText);
        mPhysicalDamageIncreaseText = (EditText) findViewById(R.id.physicalDamageIncrease_editText);
        mBossAttackIncreaseText = (EditText) findViewById(R.id.bossAttackIncrease_editText);
        mPlayerAttackIncrease = (EditText) findViewById(R.id.playerAttackIncrease_editText);
        mCritRate = (EditText) findViewById(R.id.critRate_editText);
        mCritAttack = (EditText) findViewById(R.id.critAttack_editText);
        mCritDamge = (EditText) findViewById(R.id.critDamage_editText);
        mSubmitBotton = (Button) findViewById(R.id.submit_botton);

    }
}
