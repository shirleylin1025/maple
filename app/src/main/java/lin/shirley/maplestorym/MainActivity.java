package lin.shirley.maplestorym;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private int physicalAttack, physicalAttackIncrease ,physicalDamageIncrease
            , magicAttack, magicAttackIncrease, magicDamageIncrease,
            bossAttackIncrease,
            playerAttackIncrease,
            critRate,critAttack,critDamge
            ;
    private TextView mPhysicalAttackTextView;
    private EditText mPhysicalAttackText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhysicalAttackText= (EditText) findViewById(R.id.physicalAttack_editText);
        mPhysicalAttackTextView= (TextView) findViewById(R.id.physicalAttack_textView);
    }
}
