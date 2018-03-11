import pandas as pd
from datetime import datetime
from rpy2.robjects import r, pandas2ri

def using_pandas(ds):
    pandas2ri.activate()

    r_df = r['iris']

    p_df = pd.DataFrame(r_df)

    #print("Panda df from R df")
    #print(p_df)

    ts = pd.Timestamp(datetime(2012, 5, 1))
    return ts


# Using R stats and graphics
def using_rstats():
    from rpy2.robjects.packages import importr

    graphics = importr('graphics')
    grdevices = importr('grDevices')
    base = importr('base')
    stats = importr('stats')

    import array

    x = array.array('i', range(10))
    y = stats.rnorm(10)

    grdevices.X11()

    graphics.par(mfrow = array.array('i', [2,2]))
    graphics.plot(x, y, ylab = "foo/bar", col = "red")

    kwargs = {'ylab':"foo/bar", 'type':"b", 'col':"blue", 'log':"x"}
    graphics.plot(x, y, **kwargs)


    m = base.matrix(stats.rnorm(100), ncol=5)
    pca = stats.princomp(m)
    graphics.plot(pca, main="Eigen values")
    stats.biplot(pca, main="biplot")
    return 1

# Using rpy2 to call R functions
def using_rpy2():
    from rpy2 import robjects as ro

    ro.r('''
            # create a function `f`
            f <- function(r, verbose=FALSE) {
                if (verbose) {
                    cat("I am calling f().\n")
                }
                2 * pi * r
            }
            # call the function `f` with argument value 3
            ''')

    r_f = ro.globalenv['f']

    print(r_f.r_repr())

    res = r_f(3)

    print(type(res))
    return res[0]

