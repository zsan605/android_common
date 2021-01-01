package com.zsan605.common.utils

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.*

/**
 * @author: created by zsan605
 * @github：https://github.com/zsan605
 * @function: 功能描述
 * @date: 2021/1/1 11:23
 */
class AdMobUtil {

    private val TAG = "AdMobUtil"

    fun newInterstitialAd(ctx: Context, unitId: String): InterstitialAd {
        val interstitialAd = InterstitialAd(ctx)
        interstitialAd.adUnitId = unitId
        interstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                interstitialAd.loadAd(AdRequest.Builder().build())
            }
        }
        interstitialAd.loadAd(AdRequest.Builder().build())
        return interstitialAd
    }

    fun showInterstitialAd(ad: InterstitialAd) {
        if (ad.isLoaded) {
            ad.show()
        } else {
            Log.d(TAG, "The interstitial wasn't loaded yet.")
        }
    }

    companion object {
        val instance: AdMobUtil by lazy {
            AdMobUtil()
        }
    }
}