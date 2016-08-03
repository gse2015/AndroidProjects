package gse.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.EmptyStackException;


public class MainActivity extends AppCompatActivity {

    private Button[] btnDigitalAry = new Button[10];
    private Button btnDot;
    private Button btnBackspace;
    private Button btnClear;
    private Button btnEqual;
    private Button[] btnOperator = new Button[4];
    private Button btnLeftBracket;
    private Button btnRightBracket;
    private TextView tvResult;
    private Calculator calc = new Calculator();
    private String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collectButton();
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    private View.OnClickListener myCliceListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int btnID = view.getId();
            try {
                if (btnID == R.id.btClear){
                    calc.clear();
                    result = calc.getExpression();
                }else if (btnID == R.id.btBackspace){
                    calc.backsapce();
                    result = calc.getExpression();
                }else if (btnID == R.id.btEqual){
                    result = calc.calculate();
                    calc.clear();
                }else{
                    Button btn = (Button) findViewById(btnID);
                    calc.inputCharactor(btn.getText().charAt(0));
                    result = calc.getExpression();
                }
                if (result.isEmpty())
                    result = "0";
                tvResult.setText(result);
            } catch (CalcException | EmptyStackException | ArithmeticException e) {
                e.printStackTrace();
            }
        }
    };

    private void collectButton(){
        btnDot = (Button) findViewById(R.id.btDot);
        btnDot.setOnClickListener(myCliceListener);

        btnBackspace = (Button) findViewById(R.id.btBackspace);
        btnBackspace.setOnClickListener(myCliceListener);
        btnClear = (Button) findViewById(R.id.btClear);
        btnClear.setOnClickListener(myCliceListener);
        btnEqual = (Button) findViewById(R.id.btEqual);
        btnEqual.setOnClickListener(myCliceListener);
        btnLeftBracket = (Button) findViewById(R.id.btLeftBracket);
        btnLeftBracket.setOnClickListener(myCliceListener);
        btnRightBracket = (Button) findViewById(R.id.btRightBracket);
        btnRightBracket.setOnClickListener(myCliceListener);

        btnDigitalAry[0] = (Button) findViewById(R.id.bt0);
        btnDigitalAry[1] = (Button) findViewById(R.id.bt1);
        btnDigitalAry[2] = (Button) findViewById(R.id.bt2);
        btnDigitalAry[3] = (Button) findViewById(R.id.bt3);
        btnDigitalAry[4] = (Button) findViewById(R.id.bt4);
        btnDigitalAry[5] = (Button) findViewById(R.id.bt5);
        btnDigitalAry[6] = (Button) findViewById(R.id.bt6);
        btnDigitalAry[7] = (Button) findViewById(R.id.bt7);
        btnDigitalAry[8] = (Button) findViewById(R.id.bt8);
        btnDigitalAry[9] = (Button) findViewById(R.id.bt9);
        for (Button btn : btnDigitalAry){
            btn.setOnClickListener(myCliceListener);
        }

        btnOperator[0] = (Button) findViewById(R.id.btAdd);
        btnOperator[1] = (Button) findViewById(R.id.btSubtract);
        btnOperator[2] = (Button) findViewById(R.id.btMultiply);
        btnOperator[3] = (Button) findViewById(R.id.btDivide);
        for (Button btn : btnOperator){
            btn.setOnClickListener(myCliceListener);
        }
    }
}
