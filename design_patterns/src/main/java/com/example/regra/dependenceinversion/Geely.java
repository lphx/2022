package com.example.regra.dependenceinversion;

/**
 * @ClassName: Geely
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 16:34
 */
public class Geely {

    private ICourse iCourse;

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    void studyImoocCourse() {
        iCourse.studyCourse();
    }


}
