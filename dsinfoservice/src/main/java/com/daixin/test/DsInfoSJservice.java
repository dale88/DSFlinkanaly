package com.daixin.test;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@Controller
@RequestMapping("DsInfoSJservice")
public class DsInfoSJservice {

    @RequestMapping(value = "webInfoSJservice",method = RequestMethod.POST)
    public void webInfoSJService(@RequestBody String jsonstr, HttpServletRequest request, HttpServletResponse response){
        System.out.println("helloword!");
//        业务开始

//        业务结束
        PrintWriter printWriter = getWriter(response);
//        response.setStatus(HttpStatus.OK);
        printWriter.write("success");
        closeprintwriter(printWriter);

    }

    private PrintWriter getWriter(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");

        response.setContentType("application/json");
        OutputStream out =null;
        PrintWriter printWriter = null;
        try {
            out = response.getOutputStream();
            printWriter = new PrintWriter(out);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return printWriter;
    }
    private void closeprintwriter(PrintWriter printWriter){
        printWriter.flush();
        printWriter.close();
    }
}
