import math
import numpy as np

from algoritmos.algoritmos.WinogradOriginal import WinogradOriginal

def WinogradScaled(A, B, Result, N, P, M):

    CopyA = []
    CopyB = []
    for fila in A:
        CopyA.append(list(fila))

    for fila in B:
        CopyB.append(list(fila))

    a = np.linalg.norm(A, ord=np.inf)
    b = np.linalg.norm(B, ord=np.inf)
    lambda_val = math.floor(0.5 + math.log(b / a) / math.log(4))

    # Scaling
    MultiplyWithScalar(A, CopyA, len(A), len(B), 2 ** lambda_val)
    MultiplyWithScalar(B, CopyB, len(B), len(B[0]), 2 ** -lambda_val)

    # Using Winograd with scaled matrices
    WinogradOriginal(CopyA, CopyB, Result, N, P, M)

    return Result

def MultiplyWithScalar(A, CopyA, N, P, scalar):
    for i in range(N):
        for j in range(P):
            CopyA[i][j] = A[i][j] * scalar