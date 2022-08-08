package main;

// Translated and adapted to Java by Ivica Stevanovic (OFCOM CH)
// starting from the original C++ code by (NTIA, USA) available from https://github.com/NTIA/p528

// Recommendation ITU-R P.528

public class P528{
    // Class implementation of Recommendation ITU-R P.528-5
    //
    // THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
    // EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    // MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
    // IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
    // OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
    // ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
    // OTHER DEALINGS IN THE SOFTWARE.
    //
    // You may improve, modify, and create derivative works of the software or
    // any portion of the software, and you may copy and distribute such
    // modifications or works. Modified works should carry a notice stating
    // that you changed the software and should note the date and nature of
    // any such change.
    //
    // Please provide appropriate acknowledgments in any copies or
    // derivative works of this software.



    public static class Data {

        // public Data(){
        //     this.NakagamiRiceCurves =  new double[][] // Data curves corresponding Nakagami-Rice distributions
        public static double[][] NakagamiRiceCurves = new double[][] // Data curves corresponding Nakagami-Rice distributions
                {
                        // K = -40 distribution
                        {
                                -0.1417, -0.1252, -0.1004, -0.0784, -0.0634,
                                -0.0515, -0.0321, -0.0155, 0.0000, 0.0156, 0.0323,
                                0.0518, 0.0639, 0.0791, 0.1016, 0.1271, 0.1441
                        },
                        {
                                -0.7676, -0.6811, -0.5497, -0.4312, -0.3504,
                                -0.2856, -0.1790, -0.0870, 0.0000, 0.0878, 0.1828,
                                0.2953, 0.3651, 0.4537, 0.5868, 0.7390, 0.8420
                        },
                        {
                                -1.3183, -1.1738, -0.9524, -0.7508, -0.6121,
                                -0.5003, -0.3151, -0.1537, 0.0000, 0.1564, 0.3269,
                                0.5308, 0.6585, 0.8218, 1.0696, 1.3572, 1.5544
                        },
                        {
                                -1.6263, -1.4507, -1.1805, -0.9332, -0.7623,
                                -0.6240, -0.3940, -0.1926, 0.0000, 0.1969, 0.4127,
                                0.6722, 0.8355, 1.0453, 1.3660, 1.7417, 2.0014
                        },
                        {
                                -1.9963, -1.7847, -1.4573, -1.1557, -0.9462,
                                -0.7760, -0.4916, -0.2410, 0.0000, 0.2478, 0.5209,
                                0.8519, 1.0615, 1.3326, 1.7506, 2.2463, 2.5931
                        },
                        {
                                -2.4355, -2.1829, -1.7896, -1.4247, -1.1695,
                                -0.9613, -0.6113, -0.3007, 0.0000, 0.3114, 0.6573,
                                1.0802, 1.3505, 1.7028, 2.2526, 2.9156, 3.3872
                        },
                        {
                                -2.9491, -2.6507, -2.1831, -1.7455, -1.4375,
                                -1.1846, -0.7567, -0.3737, 0.0000, 0.3903, 0.8281,
                                1.3698, 1.7198, 2.1808, 2.9119, 3.8143, 4.4714
                        },
                        {
                                -3.5384, -3.1902, -2.6407, -2.1218, -1.7535,
                                -1.4495, -0.9307, -0.4619, 0.0000, 0.4874, 1.0404,
                                1.7348, 2.1898, 2.7975, 3.7820, 5.0373, 5.9833
                        },
                        {
                                -4.1980, -3.7974, -3.1602, -2.5528, -2.1180,
                                -1.7565, -1.1345, -0.5662, 0.0000, 0.6045, 1.2999,
                                2.1887, 2.7814, 3.5868, 4.9288, 6.7171, 8.1319
                        },
                        {
                                -4.9132, -4.4591, -3.7313, -3.0306, -2.5247,
                                -2.1011, -1.3655, -0.6855, 0.0000, 0.7415, 1.6078,
                                2.7374, 3.5059, 4.5714, 6.4060, 8.9732, 11.0973
                        },
                        {
                                -5.6559, -5.1494, -4.3315, -3.5366, -2.9578,
                                -2.4699, -1.6150, -0.8154, 0.0000, 0.8935, 1.9530,
                                3.3611, 4.3363, 5.7101, 8.1216, 11.5185, 14.2546
                        },
                        {
                                -6.3810, -5.8252, -4.9219, -4.0366, -3.3871,
                                -2.8364, -1.8638, -0.9455, 0.0000, 1.0458, 2.2979,
                                3.9771, 5.1450, 6.7874, 9.6276, 13.4690, 16.4251
                        },
                        {
                                -7.0247, -6.4249, -5.4449, -4.4782, -3.7652,
                                -3.1580, -2.0804, -1.0574, 0.0000, 1.1723, 2.5755,
                                4.4471, 5.7363, 7.5266, 10.5553, 14.5401, 17.5511
                        },
                        {
                                -7.5229, -6.8862, -5.8424, -4.8090, -4.0446,
                                -3.3927, -2.2344, -1.1347, 0.0000, 1.2535, 2.7446,
                                4.7144, 6.0581, 7.9073, 11.0003, 15.0270, 18.0526
                        },
                        {
                                -7.8532, -7.1880, -6.0963, -5.0145, -4.2145,
                                -3.5325, -2.3227, -1.1774, 0.0000, 1.2948, 2.8268,
                                4.8377, 6.2021, 8.0724, 11.1869, 15.2265, 18.2566
                        },
                        {
                                -8.0435, -7.3588, -6.2354, -5.1234, -4.3022,
                                -3.6032, -2.3656, -1.1975, 0.0000, 1.3130, 2.8619,
                                4.8888, 6.2610, 8.1388, 11.2607, 15.3047, 18.3361
                        },
                        {
                                -8.2238, -7.5154, -6.3565, -5.2137, -4.3726,
                                -3.6584, -2.3979, -1.2121, 0.0000, 1.3255, 2.8855,
                                4.9224, 6.2992, 8.1814, 11.3076, 15.3541, 18.3864
                        }
                };

        //this.K = new double[]
        public static double[] K = new double[]
                {
                        -40, -25, -20, -18, -16, -14, -12, -10, -8, -6, -4, -2, 0, 2, 4, 6, 20
                };

        //this.P = new double[]
        public static double[] P = new double[]
                {1, 2, 5, 10, 15, 20, 30, 40, 50,
                        60, 70, 80, 85, 90, 95, 98, 99};
    }

    ;


    public static class OxygenData {
        //
        public static double[] f_0 =
                {
                        50.474214, 50.987745, 51.503360, 52.021429, 52.542418, 53.066934, 53.595775,
                        54.130025, 54.671180, 55.221384, 55.783815, 56.264774, 56.363399, 56.968211,
                        57.612486, 58.323877, 58.446588, 59.164204, 59.590983, 60.306056, 60.434778,
                        61.150562, 61.800158, 62.411220, 62.486253, 62.997984, 63.568526, 64.127775,
                        64.678910, 65.224078, 65.764779, 66.302096, 66.836834, 67.369601, 67.900868,
                        68.431006, 68.960312, 118.750334, 368.498246, 424.763020, 487.249273,
                        715.392902, 773.839490, 834.145546
                };

        public static double[] a_1 =
                {
                        0.975, 2.529, 6.193, 14.320, 31.240, 64.290, 124.600, 227.300,
                        389.700, 627.100, 945.300, 543.400, 1331.800, 1746.600, 2120.100, 2363.700,
                        1442.100, 2379.900, 2090.700, 2103.400, 2438.000, 2479.500, 2275.900, 1915.400,
                        1503.000, 1490.200, 1078.000, 728.700, 461.300, 274.000, 153.000, 80.400,
                        39.800, 18.560, 8.172, 3.397, 1.334, 940.300, 67.400, 637.700,
                        237.400, 98.100, 572.300, 183.100
                };

        public static double[] a_2 =
                {
                        9.651, 8.653, 7.709, 6.819, 5.983, 5.201, 4.474, 3.800, 3.182, 2.618, 2.109,
                        0.014, 1.654, 1.255, 0.910, 0.621, 0.083, 0.387, 0.207, 0.207, 0.386, 0.621,
                        0.910, 1.255, 0.083, 1.654, 2.108, 2.617, 3.181, 3.800, 4.473, 5.200, 5.982,
                        6.818, 7.708, 8.652, 9.650, 0.010, 0.048, 0.044, 0.049, 0.145, 0.141, 0.145
                };

        public static double[] a_3 =
                {
                        6.690, 7.170, 7.640, 8.110, 8.580, 9.060, 9.550, 9.960, 10.370,
                        10.890, 11.340, 17.030, 11.890, 12.230, 12.620, 12.950, 14.910, 13.530,
                        14.080, 14.150, 13.390, 12.920, 12.630, 12.170, 15.130, 11.740, 11.340,
                        10.880, 10.380, 9.960, 9.550, 9.060, 8.580, 8.110, 7.640, 7.170,
                        6.690, 16.640, 16.400, 16.400, 16.000, 16.000, 16.200, 14.700
                };

        public static double[] a_4 =
                {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                        0.0, 0.0
                };

        public static double[] a_5 =
                {
                        2.566, 2.246, 1.947, 1.667, 1.388, 1.349, 2.227, 3.170, 3.558, 2.560,
                        -1.172, 3.525, -2.378, -3.545, -5.416, -1.932, 6.768, -6.561, 6.957, -6.395,
                        6.342, 1.014, 5.014, 3.029, -4.499, 1.856, 0.658, -3.036, -3.968, -3.528,
                        -2.548, -1.660, -1.680, -1.956, -2.216, -2.492, -2.773, -0.439, 0.000, 0.000,
                        0.000, 0.000, 0.000, 0.000
                };

        public static double[] a_6 =
                {
                        6.850, 6.800, 6.729, 6.640, 6.526, 6.206, 5.085, 3.750, 2.654, 2.952,
                        6.135, -0.978, 6.547, 6.451, 6.056, 0.436, -1.273, 2.309, -0.776, 0.699,
                        -2.825, -0.584, -6.619, -6.759, 0.844, -6.675, -6.139, -2.895, -2.590, -3.680,
                        -5.002, -6.091, -6.393, -6.475, -6.545, -6.600, -6.650, 0.079, 0.000, 0.000,
                        0.000, 0.000, 0.000, 0.000
                };


    }

    ;

    public static class WaterVapourData {

        public static double[] f_0 =
                {
                        22.235080, 67.803960, 119.995940, 183.310087, 321.225630, 325.152888, 336.227764,
                        380.197353, 390.134508, 437.346667, 439.150807, 443.018343, 448.001085, 470.888999,
                        474.689092, 488.490108, 503.568532, 504.482692, 547.676440, 552.020960, 556.935985,
                        620.700807, 645.766085, 658.005280, 752.033113, 841.051732, 859.965698, 899.303175,
                        902.611085, 906.205957, 916.171582, 923.112692, 970.315022, 987.926764, 1780.000000
                };

        public static double[] b_1 =
                {
                        0.1079, 0.0011, 0.0007, 2.273, 0.0470, 1.514, 0.0010, 11.67, 0.0045,
                        0.0632, 0.9098, 0.1920, 10.41, 0.3254, 1.260, 0.2529, 0.0372, 0.0124,
                        0.9785, 0.1840, 497.0, 5.015, 0.0067, 0.2732, 243.4, 0.0134, 0.1325,
                        0.0547, 0.0386, 0.1836, 8.400, 0.0079, 9.009, 134.6, 17506.0
                };

        public static double[] b_2 =
                {
                        2.144, 8.732, 8.353, .668, 6.179, 1.541, 9.825, 1.048, 7.347, 5.048,
                        3.595, 5.048, 1.405, 3.597, 2.379, 2.852, 6.731, 6.731, .158, .158,
                        .159, 2.391, 8.633, 7.816, .396, 8.177, 8.055, 7.914, 8.429, 5.110,
                        1.441, 10.293, 1.919, .257, .952
                };

        public static double[] b_3 =
                {
                        26.38, 28.58, 29.48, 29.06, 24.04, 28.23, 26.93, 28.11, 21.52, 18.45, 20.07,
                        15.55, 25.64, 21.34, 23.20, 25.86, 16.12, 16.12, 26.00, 26.00, 30.86, 24.38,
                        18.00, 32.10, 30.86, 15.90, 30.60, 29.85, 28.65, 24.08, 26.73, 29.00, 25.50,
                        29.85, 196.3
                };

        public static double[] b_4 =
                {
                        .76, .69, .70, .77, .67, .64, .69, .54, .63, .60, .63, .60, .66, .66,
                        .65, .69, .61, .61, .70, .70, .69, .71, .60, .69, .68, .33, .68, .68,
                        .70, .70, .70, .70, .64, .68, 2.00
                };

        public static double[] b_5 =
                {
                        5.087, 4.930, 4.780, 5.022, 4.398, 4.893, 4.740, 5.063, 4.810, 4.230, 4.483,
                        5.083, 5.028, 4.506, 4.804, 5.201, 3.980, 4.010, 4.500, 4.500, 4.552, 4.856,
                        4.000, 4.140, 4.352, 5.760, 4.090, 4.530, 5.100, 4.700, 5.150, 5.000, 4.940,
                        4.550, 24.15
                };

        public static double[] b_6 =
                {
                        1.00, .82, .79, .85, .54, .74, .61, .89, .55, .48, .52, .50, .67, .65,
                        .64, .72, .43, .45, 1.00, 1.00, 1.00, .68, .50, 1.00, .84, .45, .84,
                        .90, .95, .53, .78, .80, .67, .90, 5.00
                };
    }

    ;

    // define structure Path
    public static class Path {
        public double d_ML__km, d_0__km, d_d__km;

        // constructor
        public Path() {
            this.d_ML__km = 0;
            this.d_0__km = 0;
            this.d_d__km = 0;
        }
    }

    ;

    public static class Terminal {
        // Heights
        double h_r__km;             // Real terminal height
        double h_e__km;             // Effective terminal height
        double delta_h__km;         // Internal terminal param.  See Recommendation text

        // Distances
        double d_r__km;             // Ray traced horizon distance
        double a__km;               // Total ray path length to horizon

        // Angles
        double phi__rad;            // Central angle between the terminal and its smooth earth horizon
        double theta__rad;          // Incident angle of the grazing ray at the terminal

        // Losses
        double A_a__db;             // Median atmospheric absorption loss, in dB

        // constructor
        public Terminal() {
            this.h_r__km = 0.;
            this.h_e__km = 0.;
            this.delta_h__km = 0.;
            this.d_r__km = 0.;
            this.a__km = 0.;
            this.phi__rad = 0.;
            this.theta__rad = 0.;
            this.A_a__db = 0.;
        }
    }

    ;

    public static class LineOfSightParams {
        // Heights
        double[] z__km;

        // Distances
        double d__km;               // Path distance between terminals
        double r_0__km;             // Direct ray length
        double r_12__km;            // Indirect ray length
        double[] D__km;

        // Angles
        double theta_h1__rad;       // Take-off angle from low terminal to high terminal, in rad
        double theta_h2__rad;       // Take-off angle from high terminal to low terminal, in rad
        double[] theta;
        double R_Tg;
        // Misc
        double a_a__km;             // Adjusted earth radius
        double delta_r__km;         // Ray length path difference
        double A_LOS__db;           // Loss due to LOS path

        public LineOfSightParams() {
            // Heights
            this.z__km = new double[]{0, 0};

            // Distances
            this.d__km = 0;               // Path distance between terminals
            this.r_0__km = 0;             // Direct ray length
            this.r_12__km = 0;            // Indirect ray length
            this.D__km = new double[]{0, 0};

            // Angles
            this.theta_h1__rad = 0;        // Take-off angle from low terminal to high terminal, in rad
            this.theta_h2__rad = 0;       // Take-off angle from high terminal to low terminal, in rad
            this.theta = new double[]{0, 0};

            // Misc
            this.a_a__km = 0;             // Adjusted earth radius
            this.delta_r__km = 0;         // Ray length path difference
            this.A_LOS__db = 0;           // Loss due to LOS path

            this.R_Tg = 0.0;
        }
    }

    ;

    public static class TroposcatterParams {
        // Distances
        double d_s__km;             // Scattering distance
        double d_z__km;             // Half the scattering distance

        // Heights
        double h_v__km;             // Height of the common volume cross-over point

        // Angles
        double theta_s;             // Scattering angle
        double theta_A;             // cross-over angle

        // Losses
        double A_s__db;             // Troposcattter Loss
        double A_s_prev__db;        // Troposcatter Loss of Previous Test Point

        // Misc
        double M_s;                 // Troposcatter Line Slope

        public TroposcatterParams() {
            // Distances
            this.d_s__km = 0;             // Scattering distance
            this.d_z__km = 0;             // Half the scattering distance

            // Heights
            this.h_v__km = 0;             // Height of the common volume cross-over point

            // Angles
            this.theta_s = 0;             // Scattering angle
            this.theta_A = 0;             // cross-over angle

            // Losses
            this.A_s__db = 0;             // Troposcattter Loss
            this.A_s_prev__db = 0;        // Troposcatter Loss of Previous Test Point

            // Misc
            this.M_s = 0;                 // Troposcatter Line Slope
        }

    }

    ;


    public static class Result {
        int propagation_mode;       // Mode of propagation

        double d__km;               // Path distance used in calculations
        public double A__db;               // Total loss
        double A_fs__db;            // Free space path loss
        double A_a__db;             // Atmospheric absorption loss, in dB

        double theta_h1__rad;        // Elevation angle of the ray at the low terminal, in rad

        double K_LOS;

        int err;

        public Result() {
            this.propagation_mode = 0;       // Mode of propagation

            this.d__km = 0;               // Path distance used in calculations
            this.A__db = 0;               // Total loss
            this.A_fs__db = 0;            // Free space path loss
            this.A_a__db = 0;             // Atmospheric absorption loss, in dB

            this.theta_h1__rad = 0;        // Elevation angle of the ray at the low terminal, in rad

            this.K_LOS = 0;

            this.err = 0;
        }
    }

    ;

    public class TransHorizonSearchParams {
        double M_d;
        double A_d0;
        double d_crx__km;
        int CASE;
        int rtn;

        public TransHorizonSearchParams() {
            this.M_d = 0;
            this.A_d0 = 0;
            this.d_crx__km = 0;
            this.CASE = 0;
            this.rtn = 0;
        }
    }

    public static class Const {

        // Various constants definitions used by the code

        public static double epsilon_0 = 8.854187817e-12;         //Vacuum permittivity (F/m)
        public static double a_0__km = 6371.0;                    // Earth radius, in km
        public static double a_e__km = 9257.0;                   // Effective Earth radius, in km
        public static double N_s = 341;
        public static double epsilon_r = 15.0;
        public static double sigma = 0.005;
        public static double LOS_EPSILON = 0.00001;
        public static double THIRD = 1.0 / 3.0;

        public static int CONST_MODE__SEARCH = 0;
        public static int CONST_MODE__DIFFRACTION = 1;
        public static int CONST_MODE__SCATTERING = 2;

        public static int CASE_1 = 1;
        public static int CASE_2 = 2;

        public static int PROP_MODE__NOT_SET = 0;
        public static int PROP_MODE__LOS = 1;
        public static int PROP_MODE__DIFFRACTION = 2;
        public static int PROP_MODE__SCATTERING = 3;

        // List of valid polarizations
        public static int POLARIZATION__HORIZONTAL = 0;
        public static int POLARIZATION__VERTICAL = 1;

        public static int Y_pi_99_INDEX = 16;

        // RETURN CODES
        public static int SUCCESS = 0;
        public static int ERROR_VALIDATION__D_KM = 1;
        public static int ERROR_VALIDATION__H_1 = 2;
        public static int ERROR_VALIDATION__H_2 = 3;
        public static int ERROR_VALIDATION__TERM_GEO = 4;
        public static int ERROR_VALIDATION__F_MHZ_LOW = 5;
        public static int ERROR_VALIDATION__F_MHZ_HIGH = 6;
        public static int ERROR_VALIDATION__PERCENT_LOW = 7;
        public static int ERROR_VALIDATION__PERCENT_HIGH = 8;
        public static int ERROR_VALIDATION__POLARIZATION = 9;
        public static int ERROR_HEIGHT_AND_DISTANCE = 10;
        public static int WARNING__DFRAC_TROPO_REGION = 20;

// Related to P835

        public static double RHO_0__M_KG = 7.5;

        public static int ERROR_HEIGHT_TOO_SMALL = -1;
        public static int ERROR_HEIGHT_TOO_LARGE = -2;


    }

    ;

    public class SlantPathAttenuationResult {
        double A_gas__db;                       // Median gaseous absorption, in dB
        double bending__rad;                    // Bending angle, in rad
        double a__km;                           // Ray length, in km
        double angle__rad;                      // Incident angle, in rad
        double delta_L__km;                     // Excess atmospheric path length, in km

        public SlantPathAttenuationResult() {
            this.A_gas__db = 0;
            this.bending__rad = 0;
            this.a__km = 0;
            this.angle__rad = 0;
            this.delta_L__km = 0;
        }
    }

    ;

    public Result tl_P528(double d__km, double h_1__meter, double h_2__meter, double f__mhz,
                          int T_pol, double p) {

        Terminal terminal_1 = new Terminal();
        Terminal terminal_2 = new Terminal();
        TroposcatterParams tropo = new TroposcatterParams();
        Path path = new Path();
        LineOfSightParams los_params = new LineOfSightParams();

        Result result = new Result();
        // reset Results struct
        result.A_fs__db = 0;
        result.A_a__db = 0;
        result.A__db = 0;
        result.d__km = 0;
        result.theta_h1__rad = 0;
        result.propagation_mode = Const.PROP_MODE__NOT_SET;

        int err = ValidateInputs(d__km, h_1__meter, h_2__meter, f__mhz, T_pol, p);
        if (err != Const.SUCCESS) {
            if (err == Const.ERROR_HEIGHT_AND_DISTANCE) {
                result.A_fs__db = 0;
                result.A_a__db = 0;
                result.A__db = 0;
                result.d__km = 0;
                result.err = err;
                return result;
            } else
                result.err = err;
            return result;
        }

        /////////////////////////////////////////////
        // Compute terminal geometries
        //

        // Step 1 for low terminal
        terminal_1.h_r__km = h_1__meter / 1000;
        terminal_1 = TerminalGeometry(f__mhz, terminal_1);

        // Step 1 for high terminal
        terminal_2.h_r__km = h_2__meter / 1000;
        terminal_2 = TerminalGeometry(f__mhz, terminal_2);

        //
        // Compute terminal geometries
        /////////////////////////////////////////////

        // Step 2
        path.d_ML__km = terminal_1.d_r__km + terminal_2.d_r__km;                     // [Eqn 3-1]

        /////////////////////////////////////////////
        // Smooth earth diffraction line calculations
        //

        // Step 3.1
        double d_3__km = path.d_ML__km + 0.5 * Math.pow(Math.pow(Const.a_e__km, 2) / f__mhz, Const.THIRD);   // [Eqn 3-2]
        double d_4__km = path.d_ML__km + 1.5 * Math.pow(Math.pow(Const.a_e__km, 2) / f__mhz, Const.THIRD);   // [Eqn 3-3]

        // Step 3.2
        double A_3__db = SmoothEarthDiffraction(terminal_1.d_r__km, terminal_2.d_r__km, f__mhz, d_3__km, T_pol);
        double A_4__db = SmoothEarthDiffraction(terminal_1.d_r__km, terminal_2.d_r__km, f__mhz, d_4__km, T_pol);

        // Step 3.3
        double M_d = (A_4__db - A_3__db) / (d_4__km - d_3__km);     // [Eqn 3-4]
        double A_d0 = A_4__db - M_d * d_4__km;                      // [Eqn 3-5]

        // Step 3.4
        double A_dML__db = (M_d * path.d_ML__km) + A_d0;           // [Eqn 3-6]
        path.d_d__km = -(A_d0 / M_d);                              // [Eqn 3-7]

        //
        // End smooth earth diffraction line calculations
        /////////////////////////////////////////////////

        double K_LOS = 0;

        // Step 4.  If the path is in the Line-of-Sight range, call LOS and then exit
        if (path.d_ML__km - d__km > 0.001) {

            result = LineOfSight(path, terminal_1, terminal_2, los_params, f__mhz, -A_dML__db, p, d__km, T_pol);
            result.propagation_mode = Const.PROP_MODE__LOS;
            result.err = Const.SUCCESS;
            return result;
        } else {
            // get K_LOS
            result = LineOfSight(path, terminal_1, terminal_2, los_params, f__mhz, -A_dML__db, p, path.d_ML__km - 1, T_pol);

            // Step 6.  Search past horizon to find crossover point between Diffraction and Troposcatter models
            TransHorizonSearchParams transparams = new TransHorizonSearchParams();
            transparams.M_d = M_d;
            transparams.A_d0 = A_d0;

            transparams = TranshorizonSearch(path, terminal_1, terminal_2, f__mhz, A_dML__db, transparams);

            /////////////////////////////////////////////
            // Compute terrain attenuation, A_T__db
            //

            // Step 7.1
            double A_d__db = M_d * d__km + A_d0;                    // [Eqn 3-14]

            // Step 7.2

            tropo = Troposcatter(path, terminal_1, terminal_2, d__km, f__mhz, tropo);

            // Step 7.3
            double A_T__db;
            if (d__km < transparams.d_crx__km) {
                // always in diffraction if less than d_crx
                A_T__db = A_d__db;
                result.propagation_mode = Const.PROP_MODE__DIFFRACTION;
            } else {
                if (transparams.CASE == Const.CASE_1) {
                    // select the lower loss mode of propagation
                    if (tropo.A_s__db <= A_d__db) {
                        A_T__db = tropo.A_s__db;
                        result.propagation_mode = Const.PROP_MODE__SCATTERING;
                    } else {
                        A_T__db = A_d__db;
                        result.propagation_mode = Const.PROP_MODE__DIFFRACTION;
                    }
                } else // CASE_2
                {
                    A_T__db = tropo.A_s__db;
                    result.propagation_mode = Const.PROP_MODE__SCATTERING;
                }
            }

            //
            // Compute terrain attenuation, A_T__db
            /////////////////////////////////////////////

            /////////////////////////////////////////////
            // Compute variability
            //

            // f_theta_h is unity for transhorizon paths
            double f_theta_h = 1;

            // compute the 50% and p% of the long-term variability distribution
            double Y_e__db, Y_e_50__db, dummy;

            double[] out = new double[2];
            out = LongTermVariability(terminal_1.d_r__km, terminal_2.d_r__km, d__km, f__mhz, p, f_theta_h, -A_T__db);
            Y_e__db = out[0];

            out = LongTermVariability(terminal_1.d_r__km, terminal_2.d_r__km, d__km, f__mhz, 50, f_theta_h, -A_T__db);
            Y_e_50__db = out[0];

            // compute the 50% and p% of the Nakagami-Rice distribution
            double ANGLE = 0.02617993878;   // 1.5 deg
            double K_t__db;
            if (tropo.theta_s >= ANGLE)        // theta_s > 1.5 deg
                K_t__db = 20;
            else if (tropo.theta_s <= 0.0)
                K_t__db = result.K_LOS;
            else
                K_t__db = (tropo.theta_s * (20.0 - result.K_LOS) / ANGLE) + result.K_LOS;

            double Y_pi_50__db = 0.0;       //  zero mean
            double Y_pi__db = NakagamiRice(K_t__db, p);

            // combine the long-term and Nakagami-Rice distributions
            double Y_total__db = CombineDistributions(Y_e_50__db, Y_e__db, Y_pi_50__db, Y_pi__db, p);

            //
            // Compute variability
            /////////////////////////////////////////////

            /////////////////////////////////////////////
            // Atmospheric absorption for transhorizon path
            //

            SlantPathAttenuationResult result_v;
            result_v = SlantPathAttenuation(f__mhz / 1000, 0, tropo.h_v__km, Math.PI / 2.0);

            result.A_a__db = terminal_1.A_a__db + terminal_2.A_a__db + 2 * result_v.A_gas__db;   // [Eqn 3-17]

            //
            // Atmospheric absorption for transhorizon path
            /////////////////////////////////////////////

            /////////////////////////////////////////////
            // Compute free-space loss
            //

            double r_fs__km = terminal_1.a__km + terminal_2.a__km + 2 * result_v.a__km;   // [Eqn 3-18]
            result.A_fs__db = 20.0 * Math.log10(f__mhz) + 20.0 * Math.log10(r_fs__km) + 32.45;       // [Eqn 3-19]

            //
            // Compute free-space loss
            /////////////////////////////////////////////

            result.d__km = d__km;
            result.A__db = result.A_fs__db + result.A_a__db + A_T__db - Y_total__db;     // [Eqn 3-20]
            result.theta_h1__rad = -terminal_1.theta__rad;
            result.err = err;
            return result;
        }
    }


    ///////////////////////////////////////////////////////////////////////////////
    int ValidateInputs(double d__km, double h_1__meter, double h_2__meter,
                       double f__mhz, int T_pol, double p)

    {

        //Const constants = new Const();
        if (d__km < 0)
            return Const.ERROR_VALIDATION__D_KM;

        if (h_1__meter < 1.5 || h_1__meter > 20000)
            return Const.ERROR_VALIDATION__H_1;

        if (h_2__meter < 1.5 || h_2__meter > 20000)
            return Const.ERROR_VALIDATION__H_2;

        if (h_1__meter > h_2__meter)
            return Const.ERROR_VALIDATION__TERM_GEO;

        if (f__mhz < 100)
            return Const.ERROR_VALIDATION__F_MHZ_LOW;

        if (f__mhz > 30000)
            return Const.ERROR_VALIDATION__F_MHZ_HIGH;

        if (T_pol != Const.POLARIZATION__HORIZONTAL &&
                T_pol != Const.POLARIZATION__VERTICAL)
            return Const.ERROR_VALIDATION__POLARIZATION;

        if (p < 1)
            return Const.ERROR_VALIDATION__PERCENT_LOW;

        if (p > 99)
            return Const.ERROR_VALIDATION__PERCENT_HIGH;

        if (h_1__meter == h_2__meter && d__km == 0)
            return Const.ERROR_HEIGHT_AND_DISTANCE;

        return Const.SUCCESS;
    }

    Terminal TerminalGeometry(double f__mhz, Terminal terminal) {
        //Const constants = new Const();
        double theta_tx__rad = 0;
        SlantPathAttenuationResult result = new SlantPathAttenuationResult();
        result = SlantPathAttenuation(f__mhz / 1000, 0, terminal.h_r__km, Math.PI / 2.0 - theta_tx__rad);
        terminal.theta__rad = Math.PI / 2.0 - result.angle__rad;
        terminal.A_a__db = result.A_gas__db;
        terminal.a__km = result.a__km;

        // compute arc distance
        double central_angle = ((Math.PI / 2.0 - result.angle__rad) - theta_tx__rad + result.bending__rad);            // [Thayer, Equ 2], rearranged
        terminal.d_r__km = Const.a_0__km * central_angle;

        terminal.phi__rad = terminal.d_r__km / Const.a_e__km;                   // [Eqn 4-1]
        terminal.h_e__km = (Const.a_e__km / Math.cos(terminal.phi__rad)) - Const.a_e__km;  // [Eqn 4-2]

        terminal.delta_h__km = terminal.h_r__km - terminal.h_e__km;      // [Eqn 4-3]

        return terminal;
    }


    // Calculation the slant path attenuation due to atmospheric gases
    SlantPathAttenuationResult SlantPathAttenuation(double f__ghz, double h_1__km, double h_2__km, double beta_1__rad) {
        //Const constants = new Const();
        SlantPathAttenuationResult result = new SlantPathAttenuationResult();

        if (beta_1__rad > Math.PI / 2.0) {
            // negative elevation angle
            // find h_G and then trace in each direction
            // see Section 2.2.2

            // compute refractive index at h_1
            double p__hPa = GlobalPressure(h_1__km);
            double T__kelvin = GlobalTemperature(h_1__km);
            double e__hPa = GlobalWetPressure(h_1__km);

            double n_1 = RefractiveIndex(p__hPa, T__kelvin, e__hPa);

            // set initial h_G at mid-point between h_1 and surface of the earth
            // then binary search to converge
            double h_G__km = h_1__km;
            double delta = h_1__km / 2;
            double diff = 100;

            double n_G;
            double grazing_term;
            double start_term;
            do {
                if (diff > 0)
                    h_G__km -= delta;
                else
                    h_G__km += delta;
                delta /= 2;

                p__hPa = GlobalPressure(h_G__km);
                T__kelvin = GlobalTemperature(h_G__km);
                e__hPa = GlobalWetPressure(h_G__km);

                n_G = RefractiveIndex(p__hPa, T__kelvin, e__hPa);

                grazing_term = n_G * (Const.a_0__km + h_G__km);
                start_term = n_1 * (Const.a_0__km + h_1__km) * Math.sin(beta_1__rad);

                diff = grazing_term - start_term;
            } while (Math.abs(diff) > 0.001);

            // converged on h_G.  Now call RayTrace in both directions with grazing angle
            SlantPathAttenuationResult result_1, result_2;
            double beta_graze__rad = Math.PI / 2.0;
            result_1 = RayTrace(f__ghz, h_G__km, h_1__km, beta_graze__rad);
            result_2 = RayTrace(f__ghz, h_G__km, h_2__km, beta_graze__rad);

            result.angle__rad = result_2.angle__rad;
            result.A_gas__db = result_1.A_gas__db + result_2.A_gas__db;
            result.a__km = result_1.a__km + result_2.a__km;
            result.bending__rad = result_1.bending__rad + result_2.bending__rad;
            result.delta_L__km = result_1.delta_L__km + result_2.delta_L__km;
        } else {
            result = RayTrace(f__ghz, h_1__km, h_2__km, beta_1__rad);
        }

        return result;
    }

    /////////////////////////////////////////////
    double GlobalTemperature(double h__km)

    {
        //Const constants = new Const();

        if (h__km < 0)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        if (h__km > 100)
            return Const.ERROR_HEIGHT_TOO_LARGE;

        if (h__km < 86) {
            double h_prime__km = ConvertToGeopotentialHeight(h__km);
            return GlobalTemperature_Regime1(h_prime__km);
        } else
            return GlobalTemperature_Regime2(h__km);
    }

    /*===========================================================================*/
    double GlobalTemperature_Regime1(double h_prime__km) {

        //Const constants = new Const();

        if (h_prime__km < 0)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        else if (h_prime__km <= 11)
            return 288.15 - 6.5 * h_prime__km;
        else if (h_prime__km <= 20)
            return 216.65;
        else if (h_prime__km <= 32)
            return 216.65 + (h_prime__km - 20);
        else if (h_prime__km <= 47)
            return 228.65 + 2.8 * (h_prime__km - 32);
        else if (h_prime__km <= 51)
            return 270.65;
        else if (h_prime__km <= 71)
            return 270.65 - 2.8 * (h_prime__km - 51);
        else if (h_prime__km <= 84.852)
            return 214.65 - 2.0 * (h_prime__km - 71);
        else
            return Const.ERROR_HEIGHT_TOO_LARGE;
    }


    /*===========================================================================*/
    double GlobalTemperature_Regime2(double h__km) {
        //Const constants = new Const();
        if (h__km < 86)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        else if (h__km <= 91)
            return 186.8673;
        else if (h__km <= 100)
            return 263.1905 - 76.3232 * Math.sqrt(1 - Math.pow((h__km - 91) / 19.9429, 2));
        else
            return Const.ERROR_HEIGHT_TOO_LARGE;
    }

    /*===========================================================================*/
    double GlobalPressure(double h__km) {
        //Const constants = new Const();

        if (h__km < 0)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        if (h__km > 100)
            return Const.ERROR_HEIGHT_TOO_LARGE;

        if (h__km < 86) {
            double h_prime__km = ConvertToGeopotentialHeight(h__km);
            return GlobalPressure_Regime1(h_prime__km);
        } else
            return GlobalPressure_Regime2(h__km);
    }

    /*===========================================================================*/
    double GlobalPressure_Regime1(double h_prime__km) {

        //Const constants = new Const();
        if (h_prime__km < 0)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        else if (h_prime__km <= 11)
            return 1013.25 * Math.pow(288.15 / (288.15 - 6.5 * h_prime__km), -34.1632 / 6.5);
        else if (h_prime__km <= 20)
            return 226.3226 * Math.exp(-34.1632 * (h_prime__km - 11) / 216.65);
        else if (h_prime__km <= 32)
            return 54.74980 * Math.pow(216.65 / (216.65 + (h_prime__km - 20)), 34.1632);
        else if (h_prime__km <= 47)
            return 8.680422 * Math.pow(228.65 / (228.65 + 2.8 * (h_prime__km - 32)), 34.1632 / 2.8);
        else if (h_prime__km <= 51)
            return 1.109106 * Math.exp(-34.1632 * (h_prime__km - 47) / 270.65);
        else if (h_prime__km <= 71)
            return 0.6694167 * Math.pow(270.65 / (270.65 - 2.8 * (h_prime__km - 51)), -34.1632 / 2.8);
        else if (h_prime__km <= 84.852)
            return 0.03956649 * Math.pow(214.65 / (214.65 - 2.0 * (h_prime__km - 71)), -34.1632 / 2.0);
        else
            return Const.ERROR_HEIGHT_TOO_LARGE;
    }

    /*===========================================================================*/
    double GlobalPressure_Regime2(double h__km) {
        //Const constants = new Const();
        if (h__km < 86)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        if (h__km > 100)
            return Const.ERROR_HEIGHT_TOO_LARGE;

        double a_0 = 95.571899;
        double a_1 = -4.011801;
        double a_2 = 6.424731e-2;
        double a_3 = -4.789660e-4;
        double a_4 = 1.340543e-6;

        return Math.exp(a_0 + a_1 * h__km + a_2 * Math.pow(h__km, 2) + a_3 * Math.pow(h__km, 3) + a_4 * Math.pow(h__km, 4));
    }

    /*===========================================================================*/
    double GlobalWaterVapourDensity(double h__km, double rho_0) {
        //Const constants = new Const();
        if (h__km < 0)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        if (h__km > 100)
            return Const.ERROR_HEIGHT_TOO_LARGE;

        double h_0__km = 2;     // scale height

        return rho_0 * Math.exp(-h__km / h_0__km);
    }

    /*===========================================================================*/
    double GlobalWaterVapourPressure(double h__km, double rho_0) {
        //Const constants = new Const();
        if (h__km < 0)
            return Const.ERROR_HEIGHT_TOO_SMALL;
        if (h__km > 100)
            return Const.ERROR_HEIGHT_TOO_LARGE;

        double rho = GlobalWaterVapourDensity(h__km, rho_0);

        double T__kelvin;
        if (h__km < 86) {
            // convert to geopotential height
            double h_prime__km = ConvertToGeopotentialHeight(h__km);
            T__kelvin = GlobalTemperature_Regime1(h_prime__km);
        } else
            T__kelvin = GlobalTemperature_Regime2(h__km);

        return WaterVapourDensityToPressure(rho, T__kelvin);
    }

    /*===========================================================================*/
    double GlobalWetPressure(double h__km) {
        //Const constants = new Const();
        double T__kelvin = GlobalTemperature(h__km);
        double P__hPa = GlobalPressure(h__km);
        double rho__g_m3 = Math.max(GlobalWaterVapourDensity(h__km, Const.RHO_0__M_KG), 2 * Math.pow(10, -6) * 216.7 * P__hPa / T__kelvin);
        double e__hPa = WaterVapourDensityToPressure(rho__g_m3, T__kelvin);

        return e__hPa;
    }

    /*===========================================================================*/

    double WaterVapourDensityToPartialPressure(double rho__g_m3, double T__kelvin) {
        // Equation 4
        double e__hPa = (rho__g_m3 * T__kelvin) / 216.7;

        return e__hPa;
    }

    /*===========================================================================*/
    double ConvertToGeopotentialHeight(double h__km) {
        return (6356.766 * h__km) / (6356.766 + h__km);
    }

    /*===========================================================================*/
    double ConvertToGeometricHeight(double h_prime__km) {
        return (6356.766 * h_prime__km) / (6356.766 - h_prime__km);
    }

    /*===========================================================================*/
    double WaterVapourDensityToPressure(double rho, double T__kelvin) {
        return (rho * T__kelvin) / 216.7;
    }

    /*===========================================================================*/
    double RefractiveIndex(double p__hPa, double T__kelvin, double e__hPa) {
        // dry term of refractivity
        double N_dry = 77.6 * p__hPa / T__kelvin;

        // wet term of refractivity
        double N_wet = 72 * e__hPa / T__kelvin + 3.75e5 * e__hPa / Math.pow(T__kelvin, 2);

        double N = N_dry + N_wet;

        double n = 1 + N * Math.pow(10, -6);

        return n;
    }

    /*===========================================================================*/
    double LayerThickness(double m, int i) {
        // Equation 14
        double delta_i__km = m * Math.exp((i - 1) / 100.);

        return delta_i__km;
    }

    /*===========================================================================*/
    SlantPathAttenuationResult RayTrace(double f__ghz, double h_1__km, double h_2__km, double beta_1__rad) {
        //Const constants = new Const();
        SlantPathAttenuationResult result = new SlantPathAttenuationResult();
        // Equations 16(a)-(c)
        int i_lower = (int) Math.floor(100 * Math.log(1e4 * h_1__km * (Math.exp(1. / 100.) - 1) + 1) + 1);
        int i_upper = (int) Math.ceil(100 * Math.log(1e4 * h_2__km * (Math.exp(1. / 100.) - 1) + 1) + 1);
        double m = ((Math.exp(2. / 100.) - Math.exp(1. / 100.)) / (Math.exp(i_upper / 100.) - Math.exp(i_lower / 100.))) * (h_2__km - h_1__km);

        double gamma_i;
        double gamma_ii;
        double n_i;
        double n_ii;
        double r_i__km;
        double r_ii__km;
        double h_i__km;
        double h_ii__km;
        double a_i__km;
        double alpha_i__rad = beta_1__rad;
        double delta_i__km;
        double delta_ii__km;
        double beta_i__rad;
        double beta_ii__rad = beta_1__rad;

        // initialize results
        result.A_gas__db = 0;
        result.bending__rad = 0;
        result.a__km = 0;
        result.delta_L__km = 0;

        // initialize starting layer
        delta_i__km = LayerThickness(m, i_lower);
        h_i__km = h_1__km + m * ((Math.exp((i_lower - 1) / 100.) - Math.exp((i_lower - 1) / 100.)) / (Math.exp(1 / 100.) - 1));
        double[] n_i_gamma_i = new double[2];
        n_i_gamma_i = GetLayerProperties(f__ghz, h_i__km + delta_i__km / 2);
        n_i = n_i_gamma_i[0];
        gamma_i = n_i_gamma_i[1];
        r_i__km = Const.a_0__km + h_i__km;

        // record bottom layer properties for alpha and beta calculations
        double r_1__km = r_i__km;
        double n_1 = n_i;

        // summation from Equation 13
        for (int i = i_lower; i <= i_upper - 1; i++) {
            delta_ii__km = LayerThickness(m, i + 1);
            h_ii__km = h_1__km + m * ((Math.exp((i + 1 - 1) / 100.) - Math.exp((i_lower - 1) / 100.)) / (Math.exp(1 / 100.) - 1));

            double[] out = GetLayerProperties(f__ghz, h_ii__km + delta_ii__km / 2);
            n_ii = out[0];
            gamma_ii = out[1];

            r_ii__km = Const.a_0__km + h_ii__km;

            delta_i__km = LayerThickness(m, i);

            // Equation 19b
            beta_i__rad = Math.asin(Math.min(1, (n_1 * r_1__km) / (n_i * r_i__km) * Math.sin(beta_1__rad)));

            // entry angle into the layer interface, Equation 18a
            alpha_i__rad = Math.asin(Math.min(1, (n_1 * r_1__km) / (n_i * r_ii__km) * Math.sin(beta_1__rad)));

            // path length through ith layer, Equation 17
            a_i__km = -r_i__km * Math.cos(beta_i__rad) + Math.sqrt(Math.pow(r_i__km, 2) * Math.pow(Math.cos(beta_i__rad), 2) + 2 * r_i__km * delta_i__km + Math.pow(delta_i__km, 2));

            result.a__km += a_i__km;
            result.A_gas__db += a_i__km * gamma_i;
            result.delta_L__km += a_i__km * (n_i - 1);     // summation, Equation 23

            beta_ii__rad = Math.asin(n_i / n_ii * Math.sin(alpha_i__rad));

            // summation of the bending angle, Equation 22a
            // the summation only goes to i_max - 1
            if (i != i_upper - 1)
                result.bending__rad += beta_ii__rad - alpha_i__rad;

            // shift for next loop
            h_i__km = h_ii__km;
            n_i = n_ii;
            gamma_i = gamma_ii;
            r_i__km = r_ii__km;
        }

        result.angle__rad = alpha_i__rad;

        return result;
    }

    /*===========================================================================*/
    double[] GetLayerProperties(double f__ghz, double h_i__km) {
        double[] n_gamma = new double[2];

        // use function pointers to get atmospheric parameters
        double T__kelvin = GlobalTemperature(h_i__km);
        double p__hPa = GlobalPressure(h_i__km);
        double e__hPa = GlobalWetPressure(h_i__km);

        // compute the refractive index for the current layer
        double n = RefractiveIndex(p__hPa, T__kelvin, e__hPa);

        // specific attenuation of layer
        double gamma = SpecificAttenuation(f__ghz, T__kelvin, e__hPa, p__hPa);

        n_gamma[0] = n;
        n_gamma[1] = gamma;

        return n_gamma;
    }

    /*===========================================================================*/
    double SpecificAttenuation(double f__ghz, double T__kelvin, double e__hPa, double p__hPa) {
        double gamma_o = OxygenSpecificAttenuation(f__ghz, T__kelvin, e__hPa, p__hPa);
        double gamma_w = WaterVapourSpecificAttenuation(f__ghz, T__kelvin, e__hPa, p__hPa);

        double gamma = gamma_o + gamma_w;   // [Eqn 1]

        return gamma;
    }

    /*===========================================================================*/
    double OxygenSpecificAttenuation(double f__ghz, double T__kelvin, double e__hPa, double p__hPa) {
        // partial Eqn 1
        double N_o = OxygenRefractivity(f__ghz, T__kelvin, e__hPa, p__hPa);
        double gamma_o = 0.1820 * f__ghz * N_o;

        return gamma_o;
    }

    /*===========================================================================*/
    double WaterVapourSpecificAttenuation(double f__ghz, double T__kelvin, double e__hPa, double p__hPa) {
        // partial Eqn 1
        double N_w = WaterVapourRefractivity(f__ghz, T__kelvin, e__hPa, p__hPa);
        double gamma_w = 0.1820 * f__ghz * N_w;

        return gamma_w;
    }

    /*===========================================================================*/


    /*===========================================================================*/
    double OxygenRefractivity(double f__ghz, double T__kelvin, double e__hPa, double p__hPa) {


        double theta = 300 / T__kelvin;

        double N = 0;

        for (int i = 0; i < OxygenData.f_0.length; i++) {
            // Equation 3, for oxygen
            double S_i = OxygenData.a_1[i] * 1e-7 * p__hPa * Math.pow(theta, 3) * Math.exp(OxygenData.a_2[i] * (1 - theta));

            // compute the width of the line, Equation 6a, for oxygen
            double delta_f__ghz = OxygenData.a_3[i] * 1e-4 * (p__hPa * Math.pow(theta, (0.8 - OxygenData.a_4[i])) + 1.1 * e__hPa * theta);

            // modify the line width to account for Zeeman splitting of the oxygen lines
            // Equation 6b, for oxygen
            delta_f__ghz = Math.sqrt(Math.pow(delta_f__ghz, 2) + 2.25e-6);

            // correction factor due to interference effects in oxygen lines
            // Equation 7, for oxygen
            double delta = (OxygenData.a_5[i] + OxygenData.a_6[i] * theta) * 1e-4 * (p__hPa + e__hPa) * Math.pow(theta, 0.8);

            double F_i = LineShapeFactor(f__ghz, OxygenData.f_0[i], delta_f__ghz, delta);

            // summation of terms...from Equation 2a, for oxygen
            N += S_i * F_i;
        }

        double N_D = NonresonantDebyeAttenuation(f__ghz, e__hPa, p__hPa, theta);

        double N_o = N + N_D;

        return N_o;
    }

    /*===========================================================================*/
    double LineShapeFactor(double f__ghz, double f_i__ghz, double delta_f__ghz, double delta) {
        double term1 = f__ghz / f_i__ghz;
        double term2 = (delta_f__ghz - delta * (f_i__ghz - f__ghz)) / (Math.pow(f_i__ghz - f__ghz, 2) + Math.pow(delta_f__ghz, 2));
        double term3 = (delta_f__ghz - delta * (f_i__ghz + f__ghz)) / (Math.pow(f_i__ghz + f__ghz, 2) + Math.pow(delta_f__ghz, 2));

        double F_i = term1 * (term2 + term3);

        return F_i;
    }


    /*===========================================================================*/
    double NonresonantDebyeAttenuation(double f__ghz, double e__hPa, double p__hPa, double theta) {
        // width parameter for the Debye spectrum, Equation 9
        double d = 5.6e-4 * (p__hPa + e__hPa) * Math.pow(theta, 0.8);

        // Equation 8
        double frac_1 = 6.14e-5 / (d * (1 + Math.pow(f__ghz / d, 2)));
        double frac_2 = (1.4e-12 * p__hPa * Math.pow(theta, 1.5)) / (1 + 1.9e-5 * Math.pow(f__ghz, 1.5));
        double N_D = f__ghz * p__hPa * Math.pow(theta, 2) * (frac_1 + frac_2);

        return N_D;
    }

    /*===========================================================================*/
    double WaterVapourRefractivity(double f__ghz, double T__kelvin, double e__hPa, double P__hPa) {

// Spectroscopic data for water vapor attenuation (Table 2)

//

        double theta = 300 / T__kelvin;

        double N_w = 0;

        for (int i = 0; i < WaterVapourData.f_0.length; i++) {
            // Equation 3, for water vapour
            double S_i = 0.1 * WaterVapourData.b_1[i] * e__hPa * Math.pow(theta, 3.5) * Math.exp(WaterVapourData.b_2[i] * (1 - theta));

            // compute the width of the line, Equation 6a, for water vapour
            double delta_f__ghz = 1e-4 * WaterVapourData.b_3[i] * (P__hPa * Math.pow(theta, WaterVapourData.b_4[i]) + WaterVapourData.b_5[i] * e__hPa * Math.pow(theta, WaterVapourData.b_6[i]));

            // modify the line width to account for Doppler broadening of water vapour lines
            // Equation 6b, for water vapour
            double term1 = 0.217 * Math.pow(delta_f__ghz, 2) + (2.1316e-12 * Math.pow(WaterVapourData.f_0[i], 2) / theta);
            delta_f__ghz = 0.535 * delta_f__ghz + Math.sqrt(term1);

            // Equation 7, for water vapour
            double delta = 0;

            double F_i = LineShapeFactor(f__ghz, WaterVapourData.f_0[i], delta_f__ghz, delta);

            // summation of terms...from Equation 2b, for water vapour
            N_w += S_i * F_i;
        }

        return N_w;
    }

    /*===========================================================================*/


    double DistanceFunction(double x__km) {
        // [Vogler 1964, Equ 13]
        double G_x__db = 0.05751 * x__km - 10.0 * Math.log10(x__km);

        return G_x__db;
    }

    double HeightFunction(double x__km, double K) {
        double F_x__db;

        // [FAA-ES-83-3, Equ 73]
        double y__db = 40.0 * Math.log10(x__km) - 117.0;

        // [Vogler 1964, Equ 13]
        double G_x__db = DistanceFunction(x__km);

        if (x__km <= 200.0) {
            double x_t__km = 450 / -Math.pow(Math.log10(K), 3);       // [Eqn 109]

            // [Eqn 110]
            if (x__km >= x_t__km) {
                if (Math.abs(y__db) < 117)
                    F_x__db = y__db;
                else
                    F_x__db = -117;
            } else
                F_x__db = 20 * Math.log10(K) - 15 + (0.000025 * Math.pow(x__km, 2) / K);
        } else if (x__km > 2000.0) {
            // [Vogler 1964] F_x ~= G_x for large x (see Figure 7)
            F_x__db = G_x__db;
        } else // Blend y__db with G_x__db for 200 < x__km < 2000
        {
            // [FAA-ES-83-3, Equ 72] weighting variable
            double W = 0.0134 * x__km * Math.exp(-0.005 * x__km);

            // [FAA-ES-83-3, Equ 75]
            F_x__db = W * y__db + (1.0 - W) * G_x__db;
        }

        return F_x__db;
    }

    double SmoothEarthDiffraction(double d_1__km, double d_2__km, double f__mhz, double d_0__km, int T_pol) {
        //Const constants = new Const();

        double s = 18000 * Const.sigma / f__mhz;

        double K;
        if (T_pol == Const.POLARIZATION__HORIZONTAL)
            K = 0.01778 * Math.pow(f__mhz, -Const.THIRD) * Math.pow(Math.pow(Const.epsilon_r - 1, 2) + Math.pow(s, 2), -0.25);
        else
            K = 0.01778 * Math.pow(f__mhz, -Const.THIRD) * Math.pow((Math.pow(Const.epsilon_r, 2) + Math.pow(s, 2)) / Math.pow(Math.pow(Const.epsilon_r - 1, 2) + Math.pow(s, 2), 0.5), 0.5);

        double B_0 = 1.607;

        // [Vogler 1964, Equ 2] with C_0 = 1 due to "4/3" Earth assumption
        double x_0__km = (B_0 - K) * Math.pow(f__mhz, Const.THIRD) * d_0__km;
        double x_1__km = (B_0 - K) * Math.pow(f__mhz, Const.THIRD) * d_1__km;
        double x_2__km = (B_0 - K) * Math.pow(f__mhz, Const.THIRD) * d_2__km;

        // Compute the distance function for the path
        double G_x__db = DistanceFunction(x_0__km);

        // Compute the height functions for the two terminals
        double F_x1__db = HeightFunction(x_1__km, K);
        double F_x2__db = HeightFunction(x_2__km, K);

        // [Vogler 1964, Equ 1] with C_1(K, b^0) = 20, which is the approximate value for all K (see Figure 5)
        return G_x__db - F_x1__db - F_x2__db - 20.0;
    }


    /*===========================================================================*/
    LineOfSightParams RayOptics(Terminal terminal_1, Terminal terminal_2, double psi, LineOfSightParams params) {
        //Const constants = new Const();

        double z = (Const.a_0__km / Const.a_e__km) - 1;       // [Eqn 7-1]
        double k_a = 1 / (1 + z * Math.cos(psi));      // [Eqn 7-2]
        params.a_a__km = Const.a_0__km * k_a;          // [Eqn 7-3]

        double delta_h_a1__km = terminal_1.delta_h__km * (params.a_a__km - Const.a_0__km) / (Const.a_e__km - Const.a_0__km);  // [Eqn 7-4]
        double delta_h_a2__km = terminal_2.delta_h__km * (params.a_a__km - Const.a_0__km) / (Const.a_e__km - Const.a_0__km);  // [Eqn 7-4]

        double[] H__km = {0, 0};
        H__km[0] = terminal_1.h_r__km - delta_h_a1__km;    // [Eqn 7-5]
        H__km[1] = terminal_2.h_r__km - delta_h_a2__km;    // [Eqn 7-5]

        double[] Hprime__km = {0, 0};
        for (int i = 0; i < 2; i++) {
            params.z__km[i] = params.a_a__km + H__km[i];                                  // [Eqn 7-6]
            params.theta[i] = Math.acos(params.a_a__km * Math.cos(psi) / params.z__km[i]) - psi;   // [Eqn 7-7]
            params.D__km[i] = params.z__km[i] * Math.sin(params.theta[i]);                    // [Eqn 7-8]

            // [Eqn 7-9]
            if (psi > 1.56)
                Hprime__km[i] = H__km[i];
            else
                Hprime__km[i] = params.D__km[i] * Math.tan(psi);
        }

        double delta_z = Math.abs(params.z__km[0] - params.z__km[1]);   // [Eqn 7-10]

        params.d__km = Math.max(params.a_a__km * (params.theta[0] + params.theta[1]), 0);  // [Eqn 7-11]

        double alpha = Math.atan((Hprime__km[1] - Hprime__km[0]) / (params.D__km[0] + params.D__km[1]));  // [Eqn 7-12]
        params.r_0__km = Math.max(delta_z, (params.D__km[0] + params.D__km[1]) / Math.cos(alpha));            // [Eqn 7-13]
        params.r_12__km = (params.D__km[0] + params.D__km[1]) / Math.cos(psi);                           // [Eqn 7-14]

        params.delta_r__km = 4.0 * Hprime__km[0] * Hprime__km[1] / (params.r_0__km + params.r_12__km);  // [Eqn 7-15]

        params.theta_h1__rad = alpha - params.theta[0];                // [Eqn 7-16]
        params.theta_h2__rad = -(alpha + params.theta[1]);             // [Eqn 7-17]

        return params;
    }

    /*===========================================================================*/
    double FindPsiAtDistance(double d__km, Path path, Terminal terminal_1, Terminal terminal_2) {
        if (d__km == 0)
            return Math.PI / 2;

        // initialize to start at mid-point
        double psi = Math.PI / 2;
        double delta_psi = -Math.PI / 4;

        double d_psi__km;

        do {
            psi += delta_psi; // new psi

            LineOfSightParams params_temp = new LineOfSightParams();
            params_temp = RayOptics(terminal_1, terminal_2, psi, params_temp);

            d_psi__km = params_temp.d__km;

            // compute delta
            if (d_psi__km > d__km)
                delta_psi = Math.abs(delta_psi) / 2;
            else
                delta_psi = -Math.abs(delta_psi) / 2;

        }
        while (Math.abs(d__km - d_psi__km) > 1e-3 && (Math.abs(delta_psi) > 1e-12));  // get within 1 meter of desired delta_r value

        return psi;
    }

    /*===========================================================================*/
    double FindPsiAtDeltaR(double delta_r__km, Path path, Terminal terminal_1, Terminal terminal_2, double terminate) {
        double psi = Math.PI / 2;
        double delta_psi = -Math.PI / 4;

        LineOfSightParams params_temp = new LineOfSightParams();
        do {
            psi += delta_psi;

            params_temp = RayOptics(terminal_1, terminal_2, psi, params_temp);

            if (params_temp.delta_r__km > delta_r__km)
                delta_psi = -Math.abs(delta_psi) / 2;
            else
                delta_psi = Math.abs(delta_psi) / 2;

        } while (Math.abs(params_temp.delta_r__km - delta_r__km) > terminate);

        return psi;
    }


    double FindDistanceAtDeltaR(double delta_r__km, Path path, Terminal terminal_1, Terminal terminal_2, double terminate) {
        double psi = Math.PI / 2;
        double delta_psi = -Math.PI / 4;

        LineOfSightParams params_temp = new LineOfSightParams();
        do {
            psi += delta_psi;

            params_temp = RayOptics(terminal_1, terminal_2, psi, params_temp);

            if (params_temp.delta_r__km > delta_r__km)
                delta_psi = -Math.abs(delta_psi) / 2;
            else
                delta_psi = Math.abs(delta_psi) / 2;

        } while (Math.abs(params_temp.delta_r__km - delta_r__km) > terminate);

        return params_temp.d__km;
    }

    /*===========================================================================*/
    Result LineOfSight(Path path, Terminal terminal_1, Terminal terminal_2, LineOfSightParams los_params,
                       double f__mhz, double A_dML__db, double p, double d__km, int T_pol) {
        double psi;
        double R_Tg;

        Result result = new Result();

        // 0.2997925 = speed of light, gigameters per sec
        double lambda__km = 0.2997925 / f__mhz;                             // [Eqn 6-1]
        double terminate = lambda__km / 1e6;

        // determine psi_limit, where you switch from free space to 2-ray model
        // lambda / 2 is the start of the lobe closest to d_ML
        double psi_limit = FindPsiAtDeltaR(lambda__km / 2, path, terminal_1, terminal_2, terminate);

        // "[d_y6__km] is the largest distance at which a free-space value is obtained in a two-ray model
        //   of reflection from a smooth earth with a reflection coefficient of -1" [ES-83-3, page 44]
        double d_y6__km = FindDistanceAtDeltaR(lambda__km / 6, path, terminal_1, terminal_2, terminate);

        /////////////////////////////////////////////
        // Determine d_0__km distance
        //

        // In IF-73, the values for d_0 (d_d in IF-77) were found to be too small when both antennas are low,
        // so this "heuristic" was developed to fix that
        // [Eqns 8-2 and 8-3]
        if (terminal_1.d_r__km >= path.d_d__km || path.d_d__km >= path.d_ML__km) {
            if (terminal_1.d_r__km > d_y6__km || d_y6__km > path.d_ML__km)
                path.d_0__km = terminal_1.d_r__km;
            else
                path.d_0__km = d_y6__km;
        } else if (path.d_d__km < d_y6__km && d_y6__km < path.d_ML__km)
            path.d_0__km = d_y6__km;
        else
            path.d_0__km = path.d_d__km;

        //
        // Determine d_0__km distance
        /////////////////////////////////////////////

        /////////////////////////////////////////////
        // Tune d_0__km distance
        //

        // Now that we have d_0, lets carefully walk it forward, 1 meter at a time, to tune it to as precise as possible without
        //      going beyond the LOS region (ie, beyond d_ML)
        double d_temp__km = path.d_0__km;
        while (true) {
            psi = FindPsiAtDistance(d_temp__km, path, terminal_1, terminal_2);

            LineOfSightParams los_result = new LineOfSightParams();
            los_result = RayOptics(terminal_1, terminal_2, psi, los_result);

            // if the resulting distance is beyond d_0 OR if we incremented again we'd be outside of LOS...
            if (los_result.d__km >= path.d_0__km || (d_temp__km + 0.001) >= path.d_ML__km) {
                // use the resulting distance as d_0
                path.d_0__km = los_result.d__km;
                break;
            }

            d_temp__km += 0.001;
        }

        //
        // Tune d_0__km distance
        /////////////////////////////////////////////

        /////////////////////////////////////////////
        // Compute loss at d_0__km
        //

        double psi_d0 = FindPsiAtDistance(path.d_0__km, path, terminal_1, terminal_2);

        los_params = RayOptics(terminal_1, terminal_2, psi_d0, los_params);

        los_params = GetPathLoss(psi_d0, path, f__mhz, psi_limit, A_dML__db, 0, T_pol, los_params);
        R_Tg = los_params.R_Tg;

        //
        // Compute loss at d_0__km
        /////////////////////////////////////////////

        // tune psi for the desired distance
        psi = FindPsiAtDistance(d__km, path, terminal_1, terminal_2);

        los_params = RayOptics(terminal_1, terminal_2, psi, los_params);

        los_params = GetPathLoss(psi, path, f__mhz, psi_limit, A_dML__db, los_params.A_LOS__db, T_pol, los_params);
        R_Tg = los_params.R_Tg;

        /////////////////////////////////////////////
        // Compute atmospheric absorption
        //

        SlantPathAttenuationResult result_slant = new SlantPathAttenuationResult();
        result_slant = SlantPathAttenuation(f__mhz / 1000, terminal_1.h_r__km, terminal_2.h_r__km, Math.PI / 2 - los_params.theta_h1__rad);

        result.A_a__db = result_slant.A_gas__db;

        //
        // Compute atmospheric absorption
        /////////////////////////////////////////////

        /////////////////////////////////////////////
        // Compute free-space loss
        //

        result.A_fs__db = 20.0 * Math.log10(los_params.r_0__km) + 20.0 * Math.log10(f__mhz) + 32.45; // [Eqn 6-4]

        //
        // Compute free-space loss
        /////////////////////////////////////////////

        /////////////////////////////////////////////
        // Compute variability
        //

        // [Eqn 13-1]
        double f_theta_h;
        if (los_params.theta_h1__rad <= 0.0)
            f_theta_h = 1.0;
        else if (los_params.theta_h1__rad >= 1.0)
            f_theta_h = 0.0;
        else
            f_theta_h = Math.max(0.5 - (1 / Math.PI) * (Math.atan(20.0 * Math.log10(32.0 * los_params.theta_h1__rad))), 0);

        double Y_e__db, Y_e_50__db, A_Y;
        double[] out = new double[2];
        out = LongTermVariability(terminal_1.d_r__km, terminal_2.d_r__km, d__km, f__mhz, p, f_theta_h, los_params.A_LOS__db);
        Y_e__db = out[0];
        A_Y = out[1];

        out = LongTermVariability(terminal_1.d_r__km, terminal_2.d_r__km, d__km, f__mhz, 50, f_theta_h, los_params.A_LOS__db);
        Y_e_50__db = out[0];
        A_Y = out[1];

        // [Eqn 13-2]
        double F_AY;
        if (A_Y <= 0.0)
            F_AY = 1.0;
        else if (A_Y >= 9.0)
            F_AY = 0.1;
        else
            F_AY = (1.1 + (0.9 * Math.cos((A_Y / 9.0) * Math.PI))) / 2.0;

        // [Eqn 175]
        double F_delta_r;
        if (los_params.delta_r__km >= (lambda__km / 2.0))
            F_delta_r = 1.0;
        else if (los_params.delta_r__km <= lambda__km / 6.0)
            F_delta_r = 0.1;
        else
            F_delta_r = 0.5 * (1.1 - (0.9 * Math.cos(((3.0 * Math.PI) / lambda__km) * (los_params.delta_r__km - (lambda__km / 6.0)))));

        double R_s = R_Tg * F_delta_r * F_AY;       // [Eqn 13-4]

        double Y_pi_99__db = 10.0 * Math.log10(f__mhz * Math.pow(result_slant.a__km, 3)) - 84.26;    // [Eqn 13-5]
        double K_t = FindKForYpiAt99Percent(Y_pi_99__db);

        double W_a = Math.pow(10.0, K_t / 10.0);         // [Eqn 13-6]
        double W_R = Math.pow(R_s, 2) + Math.pow(0.01, 2);    // [Eqn 13-7]
        double W = W_R + W_a;                       // [Eqn 13-8]

        // [Eqn 13-9]
        if (W <= 0.0)
            result.K_LOS = -40.0;
        else {
            result.K_LOS = 10.0 * Math.log10(W);

            if (result.K_LOS < -40.0)
                result.K_LOS = -40.0;
        }

        double Y_pi_50__db = 0.0;   //  zero mean
        double Y_pi__db = NakagamiRice(result.K_LOS, p);

        double Y_total__db = -CombineDistributions(Y_e_50__db, Y_e__db, Y_pi_50__db, Y_pi__db, p);

        //
        // Compute variability
        /////////////////////////////////////////////

        result.d__km = los_params.d__km;
        result.A__db = result.A_fs__db + result.A_a__db - los_params.A_LOS__db + Y_total__db;
        result.theta_h1__rad = los_params.theta_h1__rad;

        return result;
    }


    /*===========================================================================*/
    double FindKForYpiAt99Percent(double Y_pi_99__db) {

        //Const constants = new Const();
        // is Y_pi_99__db smaller than the smallest value in the distribution data
        if (Y_pi_99__db < Data.NakagamiRiceCurves[0][Const.Y_pi_99_INDEX])
            return Data.K[0];

        // search the distribution data and interpolate to find K (dependent variable)
        for (int i = 0; i < Data.K.length; i++)
            if (Y_pi_99__db - Data.NakagamiRiceCurves[i][Const.Y_pi_99_INDEX] < 0)
                return (Data.K[i] * (Y_pi_99__db - Data.NakagamiRiceCurves[i - 1][Const.Y_pi_99_INDEX]) - Data.K[i - 1] * (Y_pi_99__db - Data.NakagamiRiceCurves[i][Const.Y_pi_99_INDEX])) / (Data.NakagamiRiceCurves[i][Const.Y_pi_99_INDEX] - Data.NakagamiRiceCurves[i - 1][Const.Y_pi_99_INDEX]);

        // no match.  Y_pi_99__db is greater than the data contains.  Return largest K
        return Data.K[Data.K.length - 1];
    }

    /*===========================================================================*/
    double NakagamiRice(double K, double p) {

        //Data data = new Data();

        //auto lower_K = lower_bound(data::K.begin(), data::K.end(), K);
        //auto d_K = distance(data::K.begin(), lower_K);
        int d_K = distance_lower(Data.K, K);

        //auto lower_p = lower_bound(data::P.begin(), data::P.end(), p);
        //auto d_p = distance(data::P.begin(), lower_p);

        int d_p = distance_lower(Data.P, p);

        if (d_K == 0) // K <= -40
        {
            if (d_p == 0)
                return Data.NakagamiRiceCurves[0][0];
            else
                return LinearInterpolation(Data.P[d_p], Data.NakagamiRiceCurves[0][d_p], Data.P[d_p - 1], Data.NakagamiRiceCurves[0][d_p - 1], p);
        } else if (d_K == Data.K.length) // K > 20
        {
            if (d_p == 0)
                return Data.NakagamiRiceCurves[d_K - 1][0];
            else
                return LinearInterpolation(Data.P[d_p], Data.NakagamiRiceCurves[d_K - 1][d_p], Data.P[d_p - 1], Data.NakagamiRiceCurves[d_K - 1][d_p - 1], p);
        } else {
            if (d_p == 0)
                return LinearInterpolation(Data.K[d_K], Data.NakagamiRiceCurves[d_K][0],
                        Data.K[d_K - 1], Data.NakagamiRiceCurves[d_K - 1][0], K);
            else {
                // interpolate between K's at constant p first
                double v1 = LinearInterpolation(Data.K[d_K], Data.NakagamiRiceCurves[d_K][d_p],
                        Data.K[d_K - 1], Data.NakagamiRiceCurves[d_K - 1][d_p], K);
                double v2 = LinearInterpolation(Data.K[d_K], Data.NakagamiRiceCurves[d_K][d_p - 1],
                        Data.K[d_K - 1], Data.NakagamiRiceCurves[d_K - 1][d_p - 1], K);

                return LinearInterpolation(Data.P[d_p], v1, Data.P[d_p - 1], v2, p);
            }
        }
    }


    /*===========================================================================*/
    double CombineDistributions(double A_M, double A_p, double B_M, double B_p, double p) {
        double C_M = A_M + B_M;

        double Y_1, Y_2, Y_3;

        Y_1 = A_p - A_M;
        Y_2 = B_p - B_M;

        Y_3 = Math.sqrt(Math.pow(Y_1, 2) + Math.pow(Y_2, 2));

        if (p < 50)
            return C_M + Y_3;
        else
            return C_M - Y_3;
    }

    /*===========================================================================*/
    LineOfSightParams GetPathLoss(double psi__rad, Path path, double f__mhz, double psi_limit,
                                  double A_dML__db, double A_d_0__db, int T_pol,
                                  LineOfSightParams params) {
        double R_g, phi_g;
        double[] out = new double[2];
        out = ReflectionCoefficients(psi__rad, f__mhz, T_pol);
        R_g = out[0];
        phi_g = out[1];

        double D_v;
        if (Math.tan(psi__rad) >= 0.1)
            D_v = 1.0;
        else {
            double r_1 = params.D__km[0] / Math.cos(psi__rad);       // [Eqn 8-3]
            double r_2 = params.D__km[1] / Math.cos(psi__rad);       // [Eqn 8-3]
            double R_r = (r_1 * r_2) / params.r_12__km;    // [Eqn 8-4]

            double term_1 = (2 * R_r * (1 + Math.pow(Math.sin(psi__rad), 2))) / (params.a_a__km * Math.sin(psi__rad));
            double term_2 = Math.pow(2 * R_r / params.a_a__km, 2);
            D_v = Math.pow(1.0 + term_1 + term_2, -0.5);         // [Eqn 8-5]
        }

        // Ray-length factor, [Eqn 8-6]
        double F_r = Math.min(params.r_0__km / params.r_12__km, 1);

        params.R_Tg = R_g * D_v * F_r;                            // [Eqn 8-7]

        if (params.d__km > path.d_0__km) {
            // [Eqn 8-1]
            params.A_LOS__db = ((params.d__km - path.d_0__km) * (A_dML__db - A_d_0__db) / (path.d_ML__km - path.d_0__km)) + A_d_0__db;
        } else {
            double lambda__km = 0.2997925 / f__mhz;    // [Eqn 8-2]

            if (psi__rad > psi_limit) {
                // ignore the phase lag; Step 8-2
                params.A_LOS__db = 0;
            } else {
                // Total phase lag of the ground reflected ray relative to the direct ray

                // [Eqn 8-8]
                double phi_Tg = (2 * Math.PI * params.delta_r__km / lambda__km) + phi_g;

                // [Eqn 8-9]
                double cplx_re = 1.0 + params.R_Tg * Math.cos(phi_Tg);
                double cplx_im = -params.R_Tg * Math.sin(phi_Tg);
                double cplx_mod = Math.sqrt(Math.pow(cplx_re, 2.0) + Math.pow(cplx_im, 2.0));

                // [Eqn 8-10]
                double W_RL = Math.min(cplx_mod, 1.0);

                // [Eqn 8-11]
                double W_R0 = Math.pow(W_RL, 2);

                // [Eqn 8-12]
                params.A_LOS__db = 10.0 * Math.log10(W_R0);
            }
        }

        return params;
    }

    /*===========================================================================*/
    double[] ReflectionCoefficients(double psi__rad, double f__mhz, int T_pol) {
        //Const constants = new Const();
        double[] out = new double[2];

        double sin_psi, cos_psi;
        if (psi__rad <= 0.0) {
            psi__rad = 0.0;
            sin_psi = 0.0;
            cos_psi = 1.0;
        } else if (psi__rad >= Math.PI / 2) {
            psi__rad = Math.PI / 2;
            sin_psi = 1.0;
            cos_psi = 0.0;
        } else {
            sin_psi = Math.sin(psi__rad);
            cos_psi = Math.cos(psi__rad);
        }

        double X = (18000.0 * Const.sigma) / f__mhz;              // [Eqn 9-1]
        double Y = Const.epsilon_r - Math.pow(cos_psi, 2);               // [Eqn 9-2]
        double T = Math.sqrt(Math.pow(Y, 2) + Math.pow(X, 2)) + Y;         // [Eqn 9-3]
        double P = Math.sqrt(T * 0.5);                           // [Eqn 9-4]
        double Q = X / (2.0 * P);                           // [Eqn 9-5]

        // [Eqn 9-6]
        double B;
        if (T_pol == Const.POLARIZATION__HORIZONTAL)
            B = 1.0 / (Math.pow(P, 2) + Math.pow(Q, 2));
        else
            B = (Math.pow(Const.epsilon_r, 2) + Math.pow(X, 2)) / (Math.pow(P, 2) + Math.pow(Q, 2));

        // [Eqn 9-7]
        double A;
        if (T_pol == Const.POLARIZATION__HORIZONTAL)
            A = (2.0 * P) / (Math.pow(P, 2) + Math.pow(Q, 2));
        else
            A = (2.0 * (P * Const.epsilon_r + Q * X)) / (Math.pow(P, 2) + Math.pow(Q, 2));

        // [Eqn 9-8]
        double R_g = Math.sqrt((1.0 + (B * Math.pow(sin_psi, 2)) - (A * sin_psi)) / (1.0 + (B * Math.pow(sin_psi, 2)) + (A * sin_psi)));

        // [Eqn 9-9]
        double alpha;
        if (T_pol == Const.POLARIZATION__HORIZONTAL)
            alpha = Math.atan2(-Q, sin_psi - P);
        else
            alpha = Math.atan2((Const.epsilon_r * sin_psi) - Q, Const.epsilon_r * sin_psi - P);

        // [Eqn 9-10]
        double beta;
        if (T_pol == Const.POLARIZATION__HORIZONTAL)
            beta = Math.atan2(Q, sin_psi + P);
        else
            beta = Math.atan2((X * sin_psi) + Q, Const.epsilon_r * sin_psi + P);

        // [Eqn 9-11]
        double phi_g = alpha - beta;

        out[0] = R_g;
        out[1] = phi_g;

        return out;
    }

    /*===========================================================================*/
    double[] LongTermVariability(double d_r1__km, double d_r2__km, double d__km, double f__mhz,
                                 double p, double f_theta_h, double A_T) {

        //Const constants = new Const();
        // Data data = new Data();


        double Y_e__db;
        double A_Y;

        double d_qs__km = 65.0 * Math.pow((100.0 / f__mhz), Const.THIRD);              // [Eqn 14-1]
        double d_Lq__km = d_r1__km + d_r2__km;                              // [Eqn 14-2]
        double d_q__km = d_Lq__km + d_qs__km;                               // [Eqn 14-3]

        // [Eqn 14-4]
        double d_e__km;
        if (d__km <= d_q__km)
            d_e__km = (130.0 * d__km) / d_q__km;
        else
            d_e__km = 130.0 + d__km - d_q__km;

        // [Eqns 14-5 and 14-6]
        double g_10, g_90;
        if (f__mhz > 1600.0) {
            g_10 = 1.05;
            g_90 = 1.05;
        } else {
            g_10 = (0.21 * Math.sin(5.22 * Math.log10(f__mhz / 200.0))) + 1.28;
            g_90 = (0.18 * Math.sin(5.22 * Math.log10(f__mhz / 200.0))) + 1.23;
        }

        // Data Source for Below Consts: Tech Note 101, Vol 2
        // Column 1: Table III.4, Row A* (Page III-50)
        // Column 2: Table III.3, Row A* (Page III-49)
        // Column 3: Table III.5, Row Continental Temperate (Page III-51)

        double c_1[] = {2.93e-4, 5.25e-4, 1.59e-5};
        double c_2[] = {3.78e-8, 1.57e-6, 1.56e-11};
        double c_3[] = {1.02e-7, 4.70e-7, 2.77e-8};

        double n_1[] = {2.00, 1.97, 2.32};
        double n_2[] = {2.88, 2.31, 4.08};
        double n_3[] = {3.15, 2.90, 3.25};

        double f_inf[] = {3.2, 5.4, 0.0};
        double f_m[] = {8.2, 10.0, 3.9};

        double[] Z__db = new double[3];    // = [Y_0(90) Y_0(10) V(50)]
        for (int i = 0; i < 3; i++) {
            double f_2 = f_inf[i] + ((f_m[i] - f_inf[i]) * Math.exp(-c_2[i] * Math.pow(d_e__km, n_2[i])));

            Z__db[i] = (c_1[i] * Math.pow(d_e__km, n_1[i]) - f_2) * Math.exp(-c_3[i] * Math.pow(d_e__km, n_3[i])) + f_2;
        }

        double Y_p__db;
        if (p == 50)
            Y_p__db = Z__db[2];
        else if (p > 50) {
            double z_90 = InverseComplementaryCumulativeDistributionFunction(90.0 / 100.0);
            double z_p = InverseComplementaryCumulativeDistributionFunction(p / 100.0);
            double c_p = z_p / z_90;

            double Y = c_p * (-Z__db[0] * g_90);
            Y_p__db = Y + Z__db[2];
        } else {
            double c_p;
            if (p >= 10) {
                double z_10 = InverseComplementaryCumulativeDistributionFunction(10.0 / 100.0);
                double z_p = InverseComplementaryCumulativeDistributionFunction(p / 100.0);
                c_p = z_p / z_10;
            } else {
                // Source for values p < 10: [15], Table 10, Page 34, Climate 6
                double[] ps = {1, 2, 5, 10};
                double[] c_ps = {1.9507, 1.7166, 1.3265, 1.0000};

                int dist = distance_upper(Data.P, p);

                c_p = LinearInterpolation(ps[dist - 1], c_ps[dist - 1], ps[dist], c_ps[dist], p);
            }

            double Y = c_p * (Z__db[1] * g_10);
            Y_p__db = Y + Z__db[2];
        }

        double Y_10__db = (Z__db[1] * g_10) + Z__db[2]; // [Eqn 14-20]
        double Y_eI__db = f_theta_h * Y_p__db;          // [Eqn 14-21]
        double Y_eI_10__db = f_theta_h * Y_10__db;      // [Eqn 14-22]

        // A_Y "is used to prevent available signal powers from exceeding levels expected for free-space propagation by an unrealistic
        //      amount when the variability about L_b(50) is large and L_b(50) is near its free-space level" [ES-83-3, p3-4]

        double A_YI = (A_T + Y_eI_10__db) - 3.0;        // [Eqn 14-23]
        A_Y = Math.max(A_YI, 0);                            // [Eqn 14-24]
        Y_e__db = Y_eI__db - A_Y;                     // [Eqn 14-25]

        // For percentages less than 10%, do a correction check to,
        //    "prevent available signal powers from exceeding levels expected from free-space levels
        //     by unrealistic amounts" [Gierhart 1970]
        if (p < 10) {
            double[] c_Y = {-5.0, -4.5, -3.7, 0.0};

            //int upper = upper_bound(data::P.begin(), data::P.end(), p);
            int dist = distance_upper(Data.P, p);
            double c_Yi = LinearInterpolation(Data.P[dist - 1], c_Y[dist - 1], Data.P[dist], c_Y[dist], p);

            Y_e__db += A_T;

            if (Y_e__db > -c_Yi)
                Y_e__db = -c_Yi;

            Y_e__db -= A_T;
        }

        double[] out = new double[2];
        out[0] = Y_e__db;
        out[1] = A_Y;

        return out;
    }

    /*======================================================================*/
    public static int distance_lower(double[] ar, double k) {
        int s = 0;
        int e = ar.length;
        while (s != e) {
            int mid = s + e >> 1;
            if (ar[mid] < k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.length) {
            return ar.length;
        }
        return s;
    }

    /*======================================================================*/
    public static int distance_upper(double[] ar, double k) {
        int s = 0;
        int e = ar.length;
        while (s != e) {
            int mid = s + e >> 1;
            if (ar[mid] <= k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.length) {
            return ar.length;
        }
        return s;
    }

    /*===========================================================================*/
    double InverseComplementaryCumulativeDistributionFunction(double q) {
        double C_0 = 2.515516;
        double C_1 = 0.802853;
        double C_2 = 0.010328;
        double D_1 = 1.432788;
        double D_2 = 0.189269;
        double D_3 = 0.001308;

        double x = q;
        if (q > 0.5)
            x = 1.0 - x;

        double T_x = Math.sqrt(-2.0 * Math.log(x));

        double zeta_x = ((C_2 * T_x + C_1) * T_x + C_0) / (((D_3 * T_x + D_2) * T_x + D_1) * T_x + 1.0);

        double Q_q = T_x - zeta_x;

        if (q > 0.5)
            Q_q = -Q_q;

        return Q_q;
    }

    /*===========================================================================*/
    double LinearInterpolation(double x1, double y1, double x2, double y2, double x) {
        return (y1 * (x2 - x) + y2 * (x - x1)) / (x2 - x1);
    }

    /*===========================================================================*/
    TransHorizonSearchParams TranshorizonSearch(Path path, Terminal terminal_1, Terminal terminal_2, double f__mhz,
                                                double A_dML__db, TransHorizonSearchParams params) {
        //Const constants = new Const();
        params.CASE = Const.CONST_MODE__SEARCH;
        int k = 0;

        TroposcatterParams tropo = new TroposcatterParams();
        tropo.A_s__db = 0;

        // Step 6.1.  Initialize search parameters
        double[] d_search__km = new double[2];
        d_search__km[0] = path.d_ML__km + 3;       // d', [Eqn 3-8]
        d_search__km[1] = path.d_ML__km + 2;       // d", [Eqn 3-9]

        double[] A_s__db = {0, 0};
        double M_s = 0;

        int SEARCH_LIMIT = 100; // 100 km beyond starting point

        for (int i_search = 0; i_search < SEARCH_LIMIT; i_search++) {
            A_s__db[1] = A_s__db[0];

            // Step 6.2
            tropo = Troposcatter(path, terminal_1, terminal_2, d_search__km[0], f__mhz, tropo);
            A_s__db[0] = tropo.A_s__db;

            // if loss is less than 20 dB, the result is not within valid part of model
            if (tropo.A_s__db < 20.0) {
                d_search__km[1] = d_search__km[0];
                d_search__km[0]++;
                continue;
            }

            k++;
            if (k <= 1) // need two points to draw a line and we don't have them both yet
            {
                d_search__km[1] = d_search__km[0];
                d_search__km[0]++;
                continue;
            }

            // Step 6.3
            M_s = (A_s__db[0] - A_s__db[1]) / (d_search__km[0] - d_search__km[1]);      // [Eqn 3-10]

            if (M_s <= params.M_d) {
                params.d_crx__km = d_search__km[0];

                // Step 6.6
                double A_d__db = params.M_d * d_search__km[1] + params.A_d0;                            // [Eqn 3-11]

                if (A_s__db[1] >= A_d__db)
                    params.CASE = Const.CASE_1;
                else {
                    // Adjust the diffraction line to the troposcatter model
                    params.M_d = (A_s__db[1] - A_dML__db) / (d_search__km[1] - path.d_ML__km);   // [Eqn 3-12]
                    params.A_d0 = A_s__db[1] - (params.M_d * d_search__km[1]);                          // [Eqn 3-13]

                    params.CASE = Const.CASE_2;
                }
                params.rtn = Const.SUCCESS;
                return params;
            }

            d_search__km[1] = d_search__km[0];
            d_search__km[0]++;
        }

        // M_s was always greater than M_d.  Default to diffraction-only transhorizon model
        params.CASE = Const.CONST_MODE__DIFFRACTION;
        params.d_crx__km = d_search__km[1];
        params.rtn = Const.WARNING__DFRAC_TROPO_REGION;
        return params;
    }


    /*===========================================================================*/
    TroposcatterParams Troposcatter(Path path, Terminal terminal_1, Terminal terminal_2, double d__km, double f__mhz, TroposcatterParams tropo) {
        //Const constants = new Const();

        double Q_o, Q_a, Q_b, Q_A, Q_B;
        double z_a__km, z_b__km, Z_a__km, Z_b__km;

        tropo.d_s__km = d__km - terminal_1.d_r__km - terminal_2.d_r__km;       // [Eqn 11-2]

        if (tropo.d_s__km <= 0.0) {
            tropo.d_z__km = 0.0;
            tropo.A_s__db = 0.0;
            tropo.d_s__km = 0.0;
            tropo.h_v__km = 0.0;
            tropo.theta_s = 0.0;
            tropo.theta_A = 0.0;
        } else {
            ///////////////////////////////////////
            // Compute the geometric parameters
            //

            tropo.d_z__km = 0.5 * tropo.d_s__km;                                // [Eqn 11-6]

            double A_m = 1 / Const.a_0__km;                                             // [Eqn 11-7]
            double dN = A_m - (1.0 / Const.a_e__km);                                    // [Eqn 11-8]
            double gamma_e__km = (Const.N_s * 1e-6) / dN;                               // [Eqn 11-9]

            z_a__km = 1.0 / (2 * Const.a_e__km) * Math.pow(tropo.d_z__km / 2, 2);           // [Eqn 11-10]
            z_b__km = 1.0 / (2 * Const.a_e__km) * Math.pow(tropo.d_z__km, 2);               // [Eqn 11-11]

            Q_o = A_m - dN;                                                             // [Eqn 11-12]

            Q_a = A_m - dN / Math.exp(Math.min(35.0, z_a__km / gamma_e__km));                     // [Eqn 11-13]
            Q_b = A_m - dN / Math.exp(Math.min(35.0, z_b__km / gamma_e__km));                     // [Eqn 11-13]

            Z_a__km = (7.0 * Q_o + 6.0 * Q_a - Q_b) * (Math.pow(tropo.d_z__km, 2) / 96.0);  // [Eqn 11-14]
            Z_b__km = (Q_o + 2.0 * Q_a) * (Math.pow(tropo.d_z__km, 2) / 6.0);               // [Eqn 11-15]

            Q_A = A_m - dN / Math.exp(Math.min(35.0, Z_a__km / gamma_e__km));                     // [Eqn 11-16]
            Q_B = A_m - dN / Math.exp(Math.min(35.0, Z_b__km / gamma_e__km));                     // [Eqn 11-16]

            tropo.h_v__km = (Q_o + 2.0 * Q_A) * (Math.pow(tropo.d_z__km, 2) / 6.0);        // [Eqn 11-17]

            tropo.theta_A = (Q_o + 4.0 * Q_A + Q_B) * tropo.d_z__km / 6.0;            // [Eqn 11-18]

            tropo.theta_s = 2 * tropo.theta_A;                                        // [Eqn 11-19]

            //
            // Compute the geometric parameters
            ///////////////////////////////////////

            ///////////////////////////////////////
            // Compute the scattering efficiency term
            //
            double epsilon_1 = 5.67e-6 * Math.pow(Const.N_s, 2) - 0.00232 * Const.N_s + 0.031;           // [Eqn 11-20]
            double epsilon_2 = 0.0002 * Math.pow(Const.N_s, 2) - 0.06 * Const.N_s + 6.6;                 // [Eqn 11-21]

            double gamma = 0.1424 * (1.0 + epsilon_1 / Math.exp(Math.min(35.0, Math.pow(tropo.h_v__km / 4.0, 6))));   // [Eqn 11-22]

            double S_e__db = 83.1 - epsilon_2 / (1.0 + 0.07716 * Math.pow(tropo.h_v__km, 2)) + 20 * Math.log10(Math.pow(0.1424 / gamma, 2) * Math.exp(gamma * tropo.h_v__km));    // [Eqn 11-23]

            //
            // Compute the scattering efficiency term
            ///////////////////////////////////////

            ///////////////////////////////////////
            // Compute the scattering volume term
            //

            double X_A1__km2 = Math.pow(terminal_1.h_e__km, 2) + 4.0 * (Const.a_e__km + terminal_1.h_e__km) * Const.a_e__km * Math.pow(Math.sin(terminal_1.d_r__km / (Const.a_e__km * 2)), 2);      // [Eqn 11-24]
            double X_A2__km2 = Math.pow(terminal_2.h_e__km, 2) + 4.0 * (Const.a_e__km + terminal_2.h_e__km) * Const.a_e__km * Math.pow(Math.sin(terminal_2.d_r__km / (Const.a_e__km * 2)), 2);      // [Eqn 11-24]

            double ell_1__km = Math.sqrt(X_A1__km2) + tropo.d_z__km;                        // [Eqn 11-25]
            double ell_2__km = Math.sqrt(X_A2__km2) + tropo.d_z__km;                        // [Eqn 11-25]
            double ell__km = ell_1__km + ell_2__km;                                     // [Eqn 11-26]

            double s = (ell_1__km - ell_2__km) / ell__km;                               // [Eqn 11-27]
            double eta = gamma * tropo.theta_s * ell__km / 2;                          // [Eqn 11-28]

            double kappa = f__mhz / 0.0477;                                             // [Eqn 11-29]

            double rho_1__km = 2.0 * kappa * tropo.theta_s * terminal_1.h_e__km;      // [Eqn 11-30]
            double rho_2__km = 2.0 * kappa * tropo.theta_s * terminal_2.h_e__km;      // [Eqn 11-30]

            double SQRT2 = Math.sqrt(2);

            double A = Math.pow(1 - Math.pow(s, 2), 2);                                           // [Eqn 11-36]

            double X_v1 = Math.pow(1 + s, 2) * eta;                                          // [Eqn 11-32]
            double X_v2 = Math.pow(1 - s, 2) * eta;                                          // [Eqn 11-33]

            double q_1 = Math.pow(X_v1, 2) + Math.pow(rho_1__km, 2);                              // [Eqn 11-34]
            double q_2 = Math.pow(X_v2, 2) + Math.pow(rho_2__km, 2);                              // [Eqn 11-35]

            // [Eqn 11-37]
            double B_s = 6 + 8 * Math.pow(s, 2)
                    + 8 * (1.0 - s) * Math.pow(X_v1, 2) * Math.pow(rho_1__km, 2) / Math.pow(q_1, 2)
                    + 8 * (1.0 + s) * Math.pow(X_v2, 2) * Math.pow(rho_2__km, 2) / Math.pow(q_2, 2)
                    + 2 * (1.0 - Math.pow(s, 2)) * (1 + 2 * Math.pow(X_v1, 2) / q_1) * (1 + 2 * Math.pow(X_v2, 2) / q_2);

            // [Eqn 11-38]
            double C_s = 12
                    * Math.pow((rho_1__km + SQRT2) / rho_1__km, 2)
                    * Math.pow((rho_2__km + SQRT2) / rho_2__km, 2)
                    * (rho_1__km + rho_2__km) / (rho_1__km + rho_2__km + 2 * SQRT2);

            double temp = (A * Math.pow(eta, 2) + B_s * eta) * q_1 * q_2 / (Math.pow(rho_1__km, 2) * Math.pow(rho_2__km, 2));

            double S_v__db = 10 * Math.log10(temp + C_s);

            //
            // Compute the scattering volume term
            ///////////////////////////////////////

            tropo.A_s__db = S_e__db + S_v__db + 10.0 * Math.log10(kappa * Math.pow(tropo.theta_s, 3) / ell__km);
        }
        return tropo;
    }

}
