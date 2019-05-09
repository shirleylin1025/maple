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
    private double skillDamge;
    private TextView mExpectedValue_textView;
    private EditText mPhysicalAttackText, mPhysicalAttackIncreaseText, mPhysicalDamageIncreaseText, mMagicAttackText, mMagicAttackIncreaseText, mMagicDamageIncreaseText,
            mBossAttackIncreaseText,
            mPlayerAttackIncrease,
            mCritRate, mCritAttack, mCritDamge,
            mSkillDamageText;
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
                    Log.e("physicalAttack:", physicalAttack + "");
                }

                if ("".equals(mPhysicalAttackIncreaseText.getText().toString().trim())) {
                    physicalAttackIncrease = 0;
                } else {
                    physicalAttackIncrease = (Double.parseDouble(mPhysicalAttackIncreaseText.getText().toString())) * 0.01;
                    String.format("%.1f", physicalAttackIncrease);
                    physicalAttackIncrease++;
                    Log.e("physicalAttackIN:", physicalAttackIncrease + "");
                }

                if ("".equals(mPhysicalDamageIncreaseText.getText().toString().trim())) {
                    physicalDamageIncrease = 0;
                } else {
                    physicalDamageIncrease = (Double.parseDouble(mPhysicalDamageIncreaseText.getText().toString())) * 0.01;
                    String.format("%.1f", physicalDamageIncrease);
                    physicalDamageIncrease++;
                    Log.e("physicalDamageIncrease:", physicalDamageIncrease + "");
                }

                if ("".equals(mBossAttackIncreaseText.getText().toString().trim())) {
                    bossAttackIncrease = 0;
                } else {
                    bossAttackIncrease = (Double.parseDouble(mBossAttackIncreaseText.getText().toString())) * 0.01;
                    String.format("%.1f", bossAttackIncrease);
                    bossAttackIncrease++;
                    Log.e("bossAttackIncrease:", bossAttackIncrease + "");
                }



                if ("".equals(mCritRate.getText().toString().trim())) {
                    critRate = 0;
                } else {
                    critRate = (Double.parseDouble(mCritRate.getText().toString())) * 0.01;
                    String.format("%.2f", critRate);
                    Log.e("critRate:", critRate + "");
                }

                if ("".equals(mCritAttack.getText().toString().trim())) {
                    critAttack = 0;
                } else {
                    critAttack = Integer.parseInt(mCritAttack.getText().toString());
                    Log.e("critAttack:", critAttack + "");
                }

                if ("".equals(mCritDamge.getText().toString().trim())) {
                    critDamge = 0;
                } else {
                    critDamge = (Double.parseDouble(mCritDamge.getText().toString())) * 0.01;
                    String.format("%.2f", critDamge);
                    critDamge++;
                    Log.e("critDamge", critDamge + "");
                }

                if ("".equals(mSkillDamageText.getText().toString().trim())) {
                    skillDamge = 0;
                } else {
                    skillDamge = (Double.parseDouble(mSkillDamageText.getText().toString())) * 0.01;
                    String.format("%.1f", skillDamge);
                    Log.e("skill:", skillDamge + "");

                }

                mfinal = ((1 - critRate) * (physicalAttack * physicalAttackIncrease * skillDamge) + critRate * ((physicalAttack + critAttack) * physicalAttackIncrease * critDamge * skillDamge)) * physicalDamageIncrease;

                Log.e("value:", mfinal + "");

                mExpectedValue_textView.setText(getString(R.string.expectedValue)+mfinal+"");
            }
        });

    }

    private void findView() {
        mPhysicalAttackText = (EditText) findViewById(R.id.physicalAttack_editText);
        mExpectedValue_textView= (TextView) findViewById(R.id.expectedValue_textView);
        mPhysicalAttackIncreaseText = (EditText) findViewById(R.id.physicalAttackIncrease_editText);
        mPhysicalDamageIncreaseText = (EditText) findViewById(R.id.physicalDamageIncrease_editText);
        mBossAttackIncreaseText = (EditText) findViewById(R.id.bossAttackIncrease_editText);
        mPlayerAttackIncrease = (EditText) findViewById(R.id.playerAttackIncrease_editText);
        mCritRate = (EditText) findViewById(R.id.critRate_editText);
        mCritAttack = (EditText) findViewById(R.id.critAttack_editText);
        mCritDamge = (EditText) findViewById(R.id.critDamage_editText);
        mSkillDamageText = (EditText) findViewById(R.id.skillDamage_editText);
        mSubmitBotton = (Button) findViewById(R.id.submit_botton);

    }
}
