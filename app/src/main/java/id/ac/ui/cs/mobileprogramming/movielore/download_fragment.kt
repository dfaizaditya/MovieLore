package id.ac.ui.cs.mobileprogramming.movielore

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class download_fragment : Fragment(R.layout.download_task){

    var REQUEST_CODE_WRITE_STORAGE_PERMISION = 105

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn).setOnClickListener {
//            Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
            (activity as MainActivity).checkStoragePermissions()
//            val intent = Intent(getActivity(), PopUpWindow::class.java)
//            intent.putExtra("popuptitle", "Error")
//            intent.putExtra("popuptext", "Sorry, that email address is already used!")
//            intent.putExtra("popupbtn", "OK")
//            intent.putExtra("darkstatusbar", false)
//            startActivity(intent)
//            checkStoragePermissions(getActivity())
//            val permissionCheck = ContextCompat.checkSelfPermission(
//                getContext(),
//                Manifest.permission.WRITE_CALENDAR
//            )
        }
    }
}
