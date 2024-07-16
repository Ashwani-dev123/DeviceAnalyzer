package com.example.githhubdemo.decicetesting.fragment


import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentDeviceTestingResultBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel
import com.example.githhubdemo.decicetesting.utils.SharedViewModel
import com.example.githhubdemo.decicetesting.utils.StoragePermissionHandler
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class DeviceTestingResultFragment : BaseFragment() {

    private var _binding: FragmentDeviceTestingResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var viewModel: FeatureTestViewModel
    private lateinit var storagePermissionHandler: StoragePermissionHandler
    var pageHeight = 1120
    var pagewidth = 792


    var bmp: Bitmap? = null
    var scaledbmp:Bitmap? = null


    companion object {
        private const val STORAGE_PERMISSION_CODE = 1001
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDeviceTestingResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        storagePermissionHandler = StoragePermissionHandler()

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity()).get(FeatureTestViewModel::class.java)

        setResult()

        binding.btnFinished.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            requireActivity().finish()
        }

        binding.btnPdfShare.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            checkAndRequestPermissions()
        }
    }

    private fun setResult() {

        val totalFeatures = viewModel.responses.size
        val workingFeatures = viewModel.responses.count { it }
        val percentage = (workingFeatures.toDouble() / totalFeatures) * 100
        binding.tvResultPercentage.text = "${percentage.toInt()}%"

        sharedViewModel.buttonClicks.observe(viewLifecycleOwner, Observer { clicks ->

            clicks.forEach { (position, buttonType) ->
                Log.d("CHECKFRAGMENT", "Fragment: $position, Button: $buttonType")

                when (position) {
                    0 -> {
                        if (buttonType == "yes") {
                            binding.ivDisplayChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivDisplayChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    1 -> {
                        if (buttonType == "yes") {
                            binding.ivFlashlightChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivFlashlightChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    2 -> {
                        if (buttonType == "yes") {
                            binding.ivLoudSpeakerChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivLoudSpeakerChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    3 -> {
                        if (buttonType == "yes") {
                            binding.ivEarSpeakerChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivEarSpeakerChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    4 -> {
                        if (buttonType == "yes") {
                            binding.ivMicrophoneChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivMicrophoneChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    5 -> {
                        if (buttonType == "yes") {
                            binding.ivEarProximityChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivEarProximityChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    6 -> {
                        if (buttonType == "yes") {
                            binding.ivLightSensorChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivLightSensorChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    7 -> {
                        if (buttonType == "yes") {
                            binding.ivAccelerometerChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivAccelerometerChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    8 -> {
                        if (buttonType == "yes") {
                            binding.ivChargingChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivChargingChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    9 -> {
                        if (buttonType == "yes") {
                            binding.ivVibrationChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivVibrationChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    10 -> {
                        if (buttonType == "yes") {
                            binding.ivBluetoothChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivBluetoothChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    11 -> {
                        if (buttonType == "yes") {
                            binding.ivVolumeUpChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivVolumeUpChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                    12 -> {
                        if (buttonType == "yes") {
                            binding.ivVolumeDownChecked.setImageResource(R.drawable.ic_yes)
                        }
                        else {
                            binding.ivVolumeDownChecked.setImageResource(R.drawable.ic_no)
                        }
                    }
                }

            }
        })

        binding.tvResultText.text = getConditionText(percentage)

        binding.tvDeviceCondition.text = getConditionMassage(percentage)


    }

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

    private fun generatePdf() {

        binding.btnFinished.visibility = View.GONE
        binding.btnShare.visibility = View.GONE
        // Hide the btnFinished temporarily


        // Measure and layout the ConstraintLayout with its full height and width
        val totalWidth = binding.clPdf.width
        val totalHeight = binding.clPdf.height

        // Create a bitmap for the ConstraintLayout content excluding the button
        val bitmapClMain = Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888)
        val canvasClMain = Canvas(bitmapClMain)
        binding.clMain.draw(canvasClMain)

        // Create bitmaps for NestedScrollView content by scrolling and capturing
        val scrollViewChild = binding.nestedScrollViewPdf.getChildAt(0)
        val scrollHeight = scrollViewChild.height
        val bitmapScrollView = Bitmap.createBitmap(binding.nestedScrollViewPdf.width, scrollHeight, Bitmap.Config.ARGB_8888)
        val canvasScrollView = Canvas(bitmapScrollView)
        scrollViewChild.draw(canvasScrollView)

        // Combine both bitmaps into a single bitmap
        val combinedHeight = totalHeight + scrollHeight
        val combinedBitmap = Bitmap.createBitmap(totalWidth, combinedHeight, Bitmap.Config.ARGB_8888)
        val combinedCanvas = Canvas(combinedBitmap)
        combinedCanvas.drawBitmap(bitmapClMain, 0f, 0f, null)
        combinedCanvas.drawBitmap(bitmapScrollView, 0f, totalHeight.toFloat(), null)

        // Create a PDF document
        val pdfDocument = PdfDocument()
        val pageInfo = PageInfo.Builder(combinedBitmap.width, combinedBitmap.height, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val pdfCanvas = page.canvas
        pdfCanvas.drawBitmap(combinedBitmap, 0f, 0f, null)
        pdfDocument.finishPage(page)

        // Save the PDF document to a file
        val pdfFile = File(requireContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "layout_pdf.pdf")
        savePDF(pdfFile)
        try {
            pdfDocument.writeTo(FileOutputStream(pdfFile))
        } catch (e: IOException) {
            e.printStackTrace()
        }

        // Close the document
        pdfDocument.close()

        // Show the btnFinished again after generating PDF

        binding.btnFinished.visibility = View.VISIBLE
        binding.btnShare.visibility = View.VISIBLE

    }

    private fun savePDF(pdfFile: File) {
        val documentsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val destinationFile = File(documentsDir, "DeviceTestingResult.pdf")

        try {
            pdfFile.copyTo(destinationFile, overwrite = true)
            Toast.makeText(requireContext(), "PDF saved locally at ${destinationFile.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Failed to save PDF locally.", Toast.LENGTH_SHORT).show()
        }
    }

   /* private fun generateFullNestedScrollViewPDF(): File {
        val view = binding.clMain
        val bitmap = getFullNestedScrollViewBitmap(view)

        // Create a PDF document
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height, 1).create()
        val page = pdfDocument.startPage(pageInfo)

        // Draw the bitmap onto the PDF
        val canvas = page.canvas
        canvas.drawBitmap(bitmap, 0f, 0f, null)

        // Finish the page
        pdfDocument.finishPage(page)

        // Save the PDF to a file
        val file = File(requireContext().getExternalFilesDir(null), "FullNestedScrollViewPDF.pdf")
        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(requireContext(), "PDF file generated successfully and saved locally.", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Failed to generate and save PDF locally.", Toast.LENGTH_SHORT).show()
        }

        // Close the PDF document
        pdfDocument.close()

        return file
    }
    private fun getFullNestedScrollViewBitmap(view: View): Bitmap {
        // Measure the view first
        view.measure(
            View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )

        // Create a bitmap large enough to hold the full content
        val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        // Draw the view on the canvas
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)

        // If the view is a NestedScrollView, ensure to draw all its children
        if (view is NestedScrollView) {
            drawNestedScrollViewChildren(view, canvas)
        }

        return bitmap
    }

    private fun drawNestedScrollViewChildren(nestedScrollView: NestedScrollView, canvas: Canvas) {
        var totalHeight = 0
        for (i in 0 until nestedScrollView.childCount) {
            val child = nestedScrollView.getChildAt(i)
            // Skip drawing the finished button
            if (child.id == R.id.btnFinished) {
                continue
            }

            // Measure each child view
            child.measure(
                View.MeasureSpec.makeMeasureSpec(nestedScrollView.width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            )

            // Layout each child view
            child.layout(0, totalHeight, child.measuredWidth, totalHeight + child.measuredHeight)

            // Draw the child view on the canvas
            child.draw(canvas)

            // Update total height with the height of the current child
            totalHeight += child.measuredHeight
        }
    }

    private fun savePDF(pdfFile: File) {
        val documentsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val destinationFile = File(documentsDir, "DeviceTestingResult.pdf")

        try {
            pdfFile.copyTo(destinationFile, overwrite = true)
            Toast.makeText(requireContext(), "PDF saved locally at ${destinationFile.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Failed to save PDF locally.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sharePDF(pdfFile: File) {
        val uri = FileProvider.getUriForFile(requireContext(), "${requireContext().packageName}.provider", pdfFile)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "application/pdf"
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        startActivity(Intent.createChooser(shareIntent, "Share PDF"))
    }
*/

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                generatePdf()
            } else {
                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11 and above, no need to request WRITE_EXTERNAL_STORAGE
            if (!Environment.isExternalStorageManager()) {
                // Request for All Files Access
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                startActivityForResult(intent, STORAGE_PERMISSION_CODE)
            } else {
                generatePdf()
            }
        } else {
            // For below Android 11
            if (ContextCompat.checkSelfPermission(requireContext(), WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(WRITE_EXTERNAL_STORAGE), STORAGE_PERMISSION_CODE)
            } else {
                generatePdf()
            }
        }
    }

}