package org.qiwei.app.filter;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/*" })
public class ApplicationContextFilter extends GuiceFilter implements Filter {

}