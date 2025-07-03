package com.example.githhubdemo.decicetesting.activity

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityPdfPreviewBinding
import com.example.githhubdemo.decicetesting.utils.StoragePermissionHandler
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import kotlin.math.ceil


class PdfPreviewActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPdfPreviewBinding

    private lateinit var storagePermissionHandler: StoragePermissionHandler

    companion object {
        private const val STORAGE_PERMISSION_CODE = 1001
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v: View, insets: WindowInsetsCompat ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        storagePermissionHandler = StoragePermissionHandler()

        binding.tvAppVersion.text = getString(R.string.version) + " " + SharedPrefsUtilsModule.getString(this, ShareModule.VERSION_NAME)

        initListener()

        //setResult()


        var appIcon: Drawable? = null
        try {
            val pm = packageManager
            val appInfo = pm.getApplicationInfo(packageName, 0)
            appIcon = pm.getApplicationIcon(appInfo)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        binding.ivAppIcon.setImageDrawable(appIcon)

        //showPermissionExplanationDialog()

    }

    private fun showPermissionExplanationDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Permission Explanation")
        builder.setMessage("Our app needs access to user device's storage to save PDF files. This permission allows us to save PDFs that you generate or download within the app, ensuring that your documents are easily accessible whenever you need them. We value your privacy and are committed to protecting your data.")
        builder.setPositiveButton("OK"
        ) { dialog, which -> dialog.dismiss() }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun initListener() {
        binding.btnBack.setOnClickListener(this)
        binding.btnSharePdf.setOnClickListener(this)
    }

   /* private fun setResult() {

        val clicks = ButtonClickTracker.buttonClicks
        val percentage = (ButtonClickTracker.getTotal().toDouble() / clicks.size) * 100
        binding.tvResultPercentage.text = "${percentage.toInt()}%"



        clicks.forEach { (position, buttonType) ->
            Log.d("CHECKFRAGMENT", "***** >>> Fragment: $position, Button: $buttonType")

            when (position) {
                0 -> {
                    if (buttonType == "yes") {
                        binding.ivDisplayChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivDisplayChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                1 -> {
                    if (buttonType == "yes") {
                        binding.ivFlashlightChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivFlashlightChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                2 -> {
                    if (buttonType == "yes") {
                        binding.ivLoudSpeakerChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivLoudSpeakerChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                3 -> {
                    if (buttonType == "yes") {
                        binding.ivEarSpeakerChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivEarSpeakerChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                4 -> {
                    if (buttonType == "yes") {
                        binding.ivMicrophoneChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivMicrophoneChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                5 -> {
                    if (buttonType == "yes") {
                        binding.ivEarProximityChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivEarProximityChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                6 -> {
                    if (buttonType == "yes") {
                        binding.ivLightSensorChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivLightSensorChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                7 -> {
                    if (buttonType == "yes") {
                        binding.ivAccelerometerChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivAccelerometerChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                8 -> {
                    if (buttonType == "yes") {
                        binding.ivChargingChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivChargingChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                9 -> {
                    if (buttonType == "yes") {
                        binding.ivVibrationChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivVibrationChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                10 -> {
                    if (buttonType == "yes") {
                        binding.ivBluetoothChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivBluetoothChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                11 -> {
                    if (buttonType == "yes") {
                        binding.ivVolumeUpChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivVolumeUpChecked.setImageResource(R.drawable.ic_no)
                    }
                }

                12 -> {
                    if (buttonType == "yes") {
                        binding.ivVolumeDownChecked.setImageResource(R.drawable.ic_yes)
                    } else {
                        binding.ivVolumeDownChecked.setImageResource(R.drawable.ic_no)
                    }
                }
            }

        }



        binding.tvResultText.text = getConditionText(percentage)

        binding.tvDeviceCondition.text = getConditionMassage(percentage)

        //ButtonClickTracker.clearClicks()

    }*/

    private fun getConditionText(percentage: Double): String {
        return when {
            percentage >= 90 -> getString(R.string.excellent)
            percentage >= 70 -> getString(R.string.good)
            percentage >= 50 -> getString(R.string.fair)
            percentage >= 30 -> getString(R.string.average)
            percentage >= 10 -> getString(R.string.bad)
            else -> "Needs Improvement"
        }
    }

    private fun getConditionMassage(percentage: Double): String {
        return when {
            percentage >= 90 -> getString(R.string.your_device_is_in_excellent)
            percentage >= 70 -> getString(R.string.your_device_is_in_good)
            percentage >= 50 -> getString(R.string.your_device_is_in_fair)
            percentage >= 30 -> getString(R.string.your_device_is_in_average)
            percentage >= 10 -> getString(R.string.your_device_is_in_poor)
            else -> getString(R.string.your_device_is_in_very_poor)
        }
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnBack -> {
                finish()
            }

            R.id.btnSharePdf -> {
                checkAndRequestPermissions()
            }
        }
    }

    private fun captureScrollViewContent(scrollView: ScrollView): Bitmap {
        // Measure and layout the ScrollView
        scrollView.measure(
            View.MeasureSpec.makeMeasureSpec(scrollView.width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(scrollView.height, View.MeasureSpec.UNSPECIFIED)
        )
        //scrollView.layout(0, 0, scrollView.measuredWidth, scrollView.measuredHeight)

        val bitmap = Bitmap.createBitmap(
            scrollView.width,
            scrollView.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        scrollView.draw(canvas)

        return bitmap
    }


    private fun generatePdfFromBitmap(bitmap: Bitmap, outputStream: OutputStream) {
        val document = PdfDocument()
        val pageHeight = bitmap.height // Page height in points (e.g., 1120 for A4)
        val pageWidth = bitmap.width  // Page width in points (e.g., 792 for A4)

        val totalPages = ceil(bitmap.height / pageHeight.toDouble()).toInt()

        for (i in 0 until totalPages) {
            val pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
            val page = document.startPage(pageInfo)

            val canvas = page.canvas
            val paint = Paint()
            val bitmapOffsetY = -i * pageHeight
            canvas.drawBitmap(bitmap, 0f, bitmapOffsetY.toFloat(), paint)

            document.finishPage(page)
        }

        document.writeTo(outputStream)
        document.close()
    }


    private fun savePdfToFile(bitmap: Bitmap) {
        val pdfFile = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
            "DeviceResult_" + System.currentTimeMillis() + ".pdf"
        )
        val outputStream = FileOutputStream(pdfFile)
        generatePdfFromBitmap(bitmap, outputStream)
        outputStream.close()
        savePDF(pdfFile)

    }


    private fun generatePdf() {
        val bitmap = captureScrollViewContent(binding.clMain)
        savePdfToFile(bitmap)
    }

    private fun savePDF(pdfFile: File) {
        try {
            Toast.makeText(this, "PDF saved Successfully", Toast.LENGTH_LONG)
                .show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to save PDF locally.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                generatePdf()
                showPermissionExplanationDialog()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (Environment.isExternalStorageManager()) {
                    generatePdf()
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                startActivityForResult(intent, STORAGE_PERMISSION_CODE)
            } else {
                generatePdf()
            }
        } else {
            // For below Android 11
            if (ContextCompat.checkSelfPermission(
                    this,
                    WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(WRITE_EXTERNAL_STORAGE),
                    STORAGE_PERMISSION_CODE
                )
            } else {
                generatePdf()
            }
        }
    }

}