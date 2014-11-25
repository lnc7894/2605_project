Imports that we used and did not code/create that were used in this project were: Appachi Commons Math, JavaFX.
These imports are needed to run the code.

File Manifest For Part 1
mathproject.java
Gn_Stuff.java
qr_fact_givens.java
qr_fact_househ.java

File Manifest For Part 2
mathproject.java
ScatterPlots.java
PowerReturn.java

Number 2 Part A
The power_method is located in Mathproject class. It takes in as parameters a 2D double array for the matrix., an double array
for the vector, a double value for epsilon, and an integer value for the iterations. We have a class named PowerReturn that is 
an object that holds 3 double values. When the power_method executes it returns a PowerReturn object. To get the eigenvalue,
eigenvector, and iterations we have getter methods: getValue(), getIterations(), getVector(). The vector returned will be of
RealVector which is an object from Apachi Commons Math. If the method fails it will return null.

Number 2 Part B
The ScatterPlots class when ran generates 1000 random 2x2 matrices of values -2 to 2.

Number 2 Part C
The ScatterPlots class when ran generates two scatterplots using the 1000 randomly generated matrices. The scatter plot however
uses size of the point instead of color to display iterations. The larger the "point" or bubble the larger the larger the
value of the iteration.

