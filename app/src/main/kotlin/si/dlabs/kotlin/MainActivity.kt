package si.dlabs.kotlin

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.squareup.picasso.Picasso
import android.widget.ImageView
import android.widget.Toast
import android.widget.TextView
import android.util.Log
import android.net.Uri
import java.io.File

public class MainActivity : ActionBarActivity() {

    var userName: String = "carlos alberto del castillo cabeza de vaca";
    var lastName: String? = null;
    var tvHelloWorld: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unknownCustomer = Customer(userName, location = null)
        unknownCustomer.setYear(10)

        val knownCustomer = Customer(userName, "NY")

        Log.e("tag", "Location of ${unknownCustomer.myLocation()}")
        //        Log.e("tag", "Location of ${unknownCustomer?.location}")
        Log.e("tag", "Location of ${knownCustomer.myLocation()}")

        Log.e("tag", "getYears ${unknownCustomer.getYears()}")
        Log.e("tag", "getYears ${knownCustomer.getYears()}")

        unknownCustomer.spend()
        knownCustomer.spend()

        var attached = knownCustomer.attach("hover")
        Log.e("tag", "Attach ${attached}");

        attached = knownCustomer.attach("hover", 23.4)
        Log.e("tag", "Attach ${attached}");

        knownCustomer.reformat()
        knownCustomer.reformat(subSequence = true, capitalize = true )

        3.show();
        accumulate();

        val croppedImage = Uri.fromFile(File("file")) : Uri;

        var authority = croppedImage.getAuthority() : String;
        
        tvHelloWorld?.setText("Hello ${userName} $authority")
        tvHelloWorld = findViewById(R.id.tv_hello_world) as TextView
        //        tvHelloWorld?.setText("Hello ${userName}")


        var imageView: ImageView = findViewById(R.id.iv_picture) as ImageView
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater()?.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.getItemId()) {
            R.id.action_settings -> {
                Toast.makeText(this, "Settings test", Toast.LENGTH_SHORT).show()
                return true;
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun Int.show() {
        Log.e("tag", "This number is $this")
    }

    fun accumulate() {
        var i = 0

        fun add() {
            i++
        }

        for (i in 1..10) {
            add()
        }

        Log.e("tag", "i is now $i")
    }
    //      It prints "i is now 10"
}
