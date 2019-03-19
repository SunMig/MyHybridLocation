package com.example.lenovo.myhybridlocation.PointClass;

import com.example.lenovo.myhybridlocation.jama.Matrix;

/**
 * Created by Lenovo on 2018/11/3.
 */

public class FingerPoint {
    private long PointId=0l;
    private MatchPoint match2Coordonate;
    private Matrix matrix;
    public FingerPoint(long id){
        this.PointId=id;
        this.match2Coordonate=new MatchPoint();

    }
    public FingerPoint(){
        this.match2Coordonate=new MatchPoint();
    }
    public long getId(){
        return PointId;
    }
    public void setId(long id){
        PointId=id;
    }
    public void setPointCoor(double x,double y){
        match2Coordonate.x=x;
        match2Coordonate.y=y;
    }
    public MatchPoint getMPoint(){
        return match2Coordonate;
    }
    public Matrix getPointSingalAttrMat(){
        return matrix;
    }
    public void addSignalAttr(double[][] vals){

       matrix=new Matrix(vals);
//        Log.i(TAG,"KNN里组合的信号指纹是："+pointSingalAttrMat.toString());
    }
}
