package com.jd.system;

import com.sun.management.OperatingSystemMXBean;
import org.junit.Test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/12/22.
 */
public class SystemInfoTest {

    private static GarbageCollectorMXBean youngGC;
    private static GarbageCollectorMXBean fullGC;
    private long uptime;
    private long processCpuTime;


    public SystemInfoTest() {

        List gcList = ManagementFactory.getGarbageCollectorMXBeans();
        if(gcList != null && !gcList.isEmpty()) {
            if(gcList.size() == 1) {
                this.youngGC = (GarbageCollectorMXBean)gcList.get(0);
            } else if(gcList.size() >= 2) {
                this.youngGC = (GarbageCollectorMXBean)gcList.get(0);
                this.fullGC = (GarbageCollectorMXBean)gcList.get(1);
            }

        }

    }

    @Test
    public void  testJvm(){
        OperatingSystemMXBean osbean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        System.out.println("虚拟机的运行参数=======>" + osbean.getTotalSwapSpaceSize());
        System.out.println("虚拟机的运行参数=======>" + osbean.getFreePhysicalMemorySize());
        System.out.println("虚拟机的运行参数=======>" + osbean.getFreeSwapSpaceSize());
        System.out.println("虚拟机的运行参数=======>" + osbean.getSystemCpuLoad());
        System.out.println("虚拟机的运行参数=======>" + osbean.getProcessCpuTime());
        System.out.println("虚拟机的运行参数=======>" + osbean.getTotalPhysicalMemorySize());

        // 线程数
        System.out.println("虚拟机的运行参数=======>" + ManagementFactory.getThreadMXBean().getThreadCount());
    }


    @Test
    public void getCpu(){
        OperatingSystemMXBean osbean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        long uptimeNow = ManagementFactory.getRuntimeMXBean().getUptime();
        long processCpuTimeNow = osbean.getProcessCpuTime();
        String cpu = "0.0";
        if(this.uptime > 0L && this.processCpuTime > 0L) {
            long l2 = uptimeNow - this.uptime;
            long l1 = processCpuTimeNow - this.processCpuTime;
            if(l2 > 0L) {
                float cpuValue = Math.min(99.0F, (float)l1 / ((float)l2 * 10000.0F * (float)osbean.getAvailableProcessors()));
                DecimalFormat df = new DecimalFormat("##0.0##");
                cpu = df.format((double)cpuValue);
            }
        }

        this.uptime = uptimeNow;
        this.processCpuTime = processCpuTimeNow;
        System.out.println("cpu============>" + cpu);
    }


    @Test
    public void testGC(){
        System.out.println(getYoungGCName());
        System.out.println(getFullGCName());
        System.out.println(getYoungGCTime());
        System.out.println(getYoungGCCount());
        System.out.println(getFullGCTime());
        System.out.println(getFullGCCount());
    }

    public static String getYoungGCName() {
        return youngGC.getName();
    }

    public static String getFullGCName() {
        return fullGC.getName();
    }

    public static String getYoungGCTime() {
        return youngGC.getCollectionTime()+"";
    }

    public static String getYoungGCCount() {
        return youngGC.getCollectionCount()+"";
    }

    public static String getFullGCTime() {
        return fullGC.getCollectionTime()+"";
    }

    public static String getFullGCCount() {
        return fullGC.getCollectionCount()+"";
    }


}
