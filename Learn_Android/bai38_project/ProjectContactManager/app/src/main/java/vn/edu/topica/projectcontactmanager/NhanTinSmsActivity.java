package vn.edu.topica.projectcontactmanager;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.topica.model.Contact;

public class NhanTinSmsActivity extends AppCompatActivity {

    TextView txtNguoiNhan;
    EditText txtNoiDung;
    ImageButton btnSend;

    Contact selectedContact=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_tin_sms);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTinNhan();
            }
        });
    }
    private void xuLyTinNhan() {
        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        final PendingIntent pendingMsgSent =
                PendingIntent.getBroadcast(this, 0, msgSent, 0);
        registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg="Đã gửi tin nhắn thành công";
                if (result != Activity.RESULT_OK) {
                    msg="Gửi tin nhắn thất bại";
                }
                Toast.makeText(NhanTinSmsActivity.this, msg,
                        Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        sms.sendTextMessage(selectedContact.getPhone(), null, txtNoiDung.getText()+"",
                pendingMsgSent, null);
    }

    private void addControls() {
        txtNguoiNhan= (TextView) findViewById(R.id.txtNguoiNhan);
        txtNoiDung= (EditText) findViewById(R.id.txtNoiDung);
        btnSend= (ImageButton) findViewById(R.id.btnSend);

        Intent intent=getIntent();
        selectedContact= (Contact) intent.getSerializableExtra("CONTACT");
        txtNguoiNhan.setText(selectedContact.getName()+"-"+selectedContact.getPhone());
    }
}
