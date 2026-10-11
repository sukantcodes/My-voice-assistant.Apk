package com.sukanta.ai

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class AiAccessibilityService : AccessibilityService() {
    companion object { var instance: AiAccessibilityService? = null }
    
    override fun onServiceConnected() { instance = this }
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}

    // Ye function screen par dikhne wale text ko dhoondh kar apne aap click karega
    fun autoClickText(text: String) {
        val root = rootInActiveWindow ?: return
        val nodes = root.findAccessibilityNodeInfosByText(text)
        nodes.firstOrNull { it.isClickable }?.performAction(AccessibilityNodeInfo.ACTION_CLICK)
    }
}
