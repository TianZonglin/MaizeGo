# MaizeGo
<pre>
MODEM is a comprehensive database of maize multidimensional omics data, including genomic, 
transcriptomic, metabolic and phenotypic information from the cellular to individual plant level. 
This initial release contains approximately 1.06 M high quality SNPs for 508 diverse inbred 
lines obtained by combining variations from RNA sequencing on whole kernels (15 days after 
pollination) of 368 lines and a 50 K array for all 508 individuals.</pre>
## database url
<pre><a href='http://modem.hzau.edu.cn/'>http://modem.hzau.edu.cn/</a></pre>
## more details see article
<pre><a href='https://academic.oup.com/database/article-lookup/doi/10.1093/database/baw117'>MODEM: multi-omics data envelopment and mining in maize</a></pre>

gantt
    dateFormat MM-DD
    title 软件开发甘特图
    section 设计
    需求: done,des1, 01-06,01-08
    原型: active,  des2, 01-09, 3d
    UI设计: des3, after des2, 5d
    未来任务: des4, after des3, 5d
    section 开发
    学习准备理解需求: crit, done, 01-06,24h
    设计框架: crit, done, after des2, 2d
    开发: crit, active, 3d
    未来任务: crit, 5d
    休息: 2d
    section 测试
    功能测试: active, a1, after des3, 3d
    压力测试: after a1  , 20h
    测试报告: 48h    
