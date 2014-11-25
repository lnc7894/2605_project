Imports that we used and did not code/create that were used in this project were: Appachi Commons Math, JavaFX.
These imports are needed to run the code.

**File Manifest For Part 1**
mathproject.java
Gn_Stuff.java
qr_fact_givens.java
qr_fact_househ.java

**Number 1 Part A**
To get QR facotorization using givens rotation:
Create an 2D double array with the data representing the matrix you want to pass in.
Create an RealMatrix using Apachi Commons Math, do this by RealMatrix matrix = new Array2DRowRealMatrix(inputMatrix);
Create an Object of the class qr_fact_givens which takes in a RealMatrix as a parameter. ex. qr_fact_givens(matrix)
When creating the object the construcotr calls the givens method in our qur_fact_givens class which will find Q and R
for the imputed RealMatrix. To get the Q and R you can we have get methods to be called on the object: getQ, getR. Which return
a RealMatrix.

To get QR facotorization using householder reflection:
Create an 2D double array with the data representing the matrix you want to pass in.
Create an RealMatrix using Apachi Commons Math, do this by RealMatrix matrix = new Array2DRowRealMatrix(inputMatrix);
Create an Object of the class qr_fact_househ which takes in a RealMatrix as a parameter. ex. qr_fact_househ h = new qr_fact_househ(matrix)
When creating the object the construcotr calls the househ method in our qur_fact_househ class which will find Q and R
for the imputed RealMatrix. To get the Q and R you can we have get methods to be called on the object: getQ, getR which return
a RealMatrix.

**Number 2 Part B**
gn_qua, gn_exp, gn_log, and gn_rat implement the modified version of Gauss-Newton. gn_qua, gn_exp, gn_log, and gn_rat are located in the
Gn_Stuff class. These methods take in no parameters but instead ask the user for the required information. The text file if put into the right
directory will be read. Also the points form the text file will be read if the same format as the test data is used. A RealVector is returned
which is created using Appachi Commons Math.

**File Manifest For Part 2**
mathproject.java
ScatterPlots.java
PowerReturn.java

**Number 2 Part A**
The power_method is located in Mathproject class. It takes in as parameters a 2D double array for the matrix., an double array
for the vector, a double value for epsilon, and an integer value for the iterations. We have a class named PowerReturn that is 
an object that holds 3 double values. When the power_method executes it returns a PowerReturn object. To get the eigenvalue,
eigenvector, and iterations we have getter methods: getValue(), getIterations(), getVector(). The vector returned will be of
RealVector which is an object from Apachi Commons Math. If the method fails it will return null.

**Number 2 Part B**
The ScatterPlots class when ran generates 1000 random 2x2 matrices of values -2 to 2.

**Number 2 Part C**
The ScatterPlots class when ran generates two scatterplots using the 1000 randomly generated matrices. The scatter plot however
uses size of the point instead of color to display iterations. The larger the "point" or bubble the larger the larger the
value of the iteration.
