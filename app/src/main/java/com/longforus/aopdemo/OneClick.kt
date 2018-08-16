package com.longforus.aopdemo

/**
 * Description :
 * @author  XQ Yang
 * @date 8/16/2018  3:42 PM
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class OneClick(val value:Int = 600)