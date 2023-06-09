package com.example.domain.emp.controller;

import com.example.domain.emp.service.impl.EmpServiceImpl;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpController implements ProcessController {

    private final String path;
    private final boolean redirect;

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("empList", EmpServiceImpl.getEmpService().selectAll());

        return new ForwardController(path, redirect);
    }
}
