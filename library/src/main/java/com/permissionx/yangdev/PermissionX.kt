package com.permissionx.yangdev

import androidx.fragment.app.FragmentActivity

/**
 * @author YangQR
 * date: 2020/5/24
 * description:
 */
object PermissionX {

    private const val TAG = "PermissionX"

    fun request(activity: FragmentActivity, vararg permissions: String, callback: PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}